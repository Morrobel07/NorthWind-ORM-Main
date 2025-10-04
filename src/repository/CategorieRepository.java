package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import comons.IFile;
import models.Categorie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategorieRepository implements IFile<Categorie, Integer> {

    private static final String FilePath = "src/data/data_Categorie.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());



    @Override
    public List<Categorie> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void persist(List<Categorie> categories) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        categories.sort((c1,c2)-> c1.getCategoryID().compareTo(c2.getCategoryID()));
        try {
            mapper.writeValue(new File(FilePath),categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObject(Categorie entity) {
        List<Categorie> categories = list();

        if (entity.getCategoryID() != null && entity.getCategoryID() != 0) {
            boolean exist = categories.stream()
                    .anyMatch(c -> Objects.equals(c.getCategoryID(), entity.getCategoryID()));
            if (exist) {
                System.out.println("Error: ya existe una categoria");
                return;
            }
        }

        int maxId = categories.stream()
                .mapToInt(Categorie::getCategoryID)
                .max()
                .orElse(0);

        entity.setCategoryID(maxId + 1);

        categories.add(entity);
        persist(categories);
        System.out.println("Categoria agregada correctamente.");
    }

    @Override
    public Categorie findById(Integer id) {
        return list().stream()
                .filter(c -> Objects.equals(c.getCategoryID(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Integer id) {
        List<Categorie> categories = list();
        categories.removeIf(c -> Objects.equals(c.getCategoryID(), id));
        persist(categories);
    }

    @Override
    public void update(Categorie entity) {
        List<Categorie> updatedCategories = list().stream()
                .map(c -> Objects.equals(c.getCategoryID(), entity.getCategoryID()) ? entity : c)
                .collect(Collectors.toList());
        persist(updatedCategories);
    }
}
