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
import comons.SeedData;
import comons.SeedData.*;
import models.Categorie;
import models.Order;

public class CategorieRepository implements IFile<Categorie> {

    private static final String FilePath = "src/data/data_Categorie.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Categorie> categories = new ArrayList<>();

    @Override
    public List<Categorie> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {

                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Categorie>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Categorie> categories) {
        try {
            mapper.writeValue(new File(FilePath), categories);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Categorie GetOne(String id) {
        List<Categorie> categories = load();
        int categorieID = Integer.parseInt(id);
        Optional<Categorie> results = categories.stream()
                .filter(c -> c.getCategoryID() == categorieID).findFirst();
        return results.orElse(null);
    }

    @Override
    public List<Categorie> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Categorie> categories = load();
        categories.removeIf(c -> c.getCategoryID() == Integer.parseInt(id));
        Save(categories);
    }

    @Override
    public void Update(Categorie entity) {
        List<Categorie> categories = load();
        // int categorieID = Integer.parseInt(id);
        List<Categorie> updatedcCategories = categories.stream()
                .map(c -> c.getCategoryID() == entity.getCategoryID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedcCategories);

    }

}
