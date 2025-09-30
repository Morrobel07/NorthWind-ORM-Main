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
import models.Order;

public class CategorieRepository implements IFile<Categorie,Integer> {

    private static final String FilePath= "src/data/data_Categorie.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());



    @Override
    public List<Categorie> list()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0 ) {

                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Categorie>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist(List<Categorie> categories )  {
        try {
            mapper.writeValue(new File(FilePath), categories);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addObject(Categorie entity) {
        List<Categorie> categories = list();

        for (Categorie e : categories) {
            if (e.getCategoryID() == entity.getCategoryID()) {
                System.out.println("No puedes realizar un duplicado del id " + entity.getCategoryID());
                return;
            }
        }
        categories.add(entity);
        persist(categories);
        System.out.println("Empleado agregado correctamente");
    }

        @Override
        public Categorie findById (Integer id) {
            List<Categorie> categories = list();
            Optional<Categorie> results = categories.stream()
                    .filter(c -> c.getCategoryID() == id).findFirst();
            return results.orElse(null);
        }

        @Override
        public void delete(Integer id) {
            List<Categorie> categories = list();
            categories.removeIf(c -> c.getCategoryID() == id);
            persist(categories);
        }

        @Override
        public void update(Categorie entity) {
            List<Categorie> categories = list();
            List<Categorie> updatedcCategories = categories.stream()
                    .map(c  -> c.getCategoryID() == entity.getCategoryID() ? entity : c)
                    .collect(Collectors.toList());
            persist(updatedcCategories);

        }




}
