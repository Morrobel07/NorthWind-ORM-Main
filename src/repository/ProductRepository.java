package repository;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.File;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import comons.IFile;
import models.Categorie;
import models.Employee;
import models.Product;

public class ProductRepository implements IFile<Product,Integer> {

    private static final String FilePath= "src/data/data_Product.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());



    @Override
    public List<Product> list()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Product>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist(List<Product> products)  {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        products.sort((c1, c2) -> c1.getProductID().compareTo(c2.getProductID()));

        try {
            mapper.writeValue(new File(FilePath), products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addObject(Product entity) {
        List<Product> products = list();

       if(entity.getProductID() != null && entity.getProductID() != 0 )
       {
           boolean exist = products.stream()
                   .anyMatch(c -> c.getProductID().equals(entity.getProductID()));
           if(exist){
               System.out.println("Error: ya existe un producto con ese id" + entity.getProductID());
               return;
           }
       }
       int maxId = products.stream()
               .mapToInt(e -> e.getProductID())
               .max()
               .orElse(0);
       entity.setProductID(maxId + 1);

       products.add(entity);
       persist(products);
       System.out.println("Producto agregado correctamente.");

    }

    @Override
    public Product findById (Integer id) {
        List<Product> products = list();
        Optional<Product> results = products.stream()
                .filter(c -> c.getProductID() == id).findFirst();
        return results.orElse(null);
    }





    @Override
    public void delete(Integer id) {
        List<Product> products = list();
        products.removeIf(c -> c.getProductID() == id);
        persist(products);
    }

    @Override
    public void update(Product entity) {
        List<Product> products = list();
        List<Product> updatedEmployees = products.stream()
                .map(c  -> c.getProductID() == entity.getProductID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedEmployees);

    }


}
