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
import models.Employee;
import models.Product;

public class ProductRepository implements IFile<Product> {

    private static final String FilePath= "src/data/data_Product.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public List<Product> products = new ArrayList<>();



    @Override
    public List<Product> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Product>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Product> products)  {
        try {
            mapper.writeValue(new File(FilePath), products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product GetOne (String id) {
        List<Product> products = load();
        int productID = Integer.parseInt(id);
        Optional<Product> results = products.stream()
                .filter(c -> c.getProductID() == productID).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<Product> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Product> products = load();
        products.removeIf(c -> c.getProductID() == Integer.parseInt(id));
        Save(products);
    }

    @Override
    public void Update(Product entity) {
        List<Product> products = load();
       //int employeeID = Integer.parseInt(id);
        List<Product> updatedEmployees = products.stream()
                .map(c  -> c.getProductID() == entity.getProductID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedEmployees);

    }


}
