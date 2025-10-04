package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.CategorieController;
import models.Categorie;
import org.junit.jupiter.api.Test;
import repository.CategorieRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategorieRepositoryTest {

    @Test
    void testListCategories() {

        CategorieRepository repo = new CategorieRepository();
        List<Categorie> list = repo.list();
        assertEquals(new CategorieController(new CategorieRepository()).getAllCategories(), list,"alista no son del mismo tipo");


    }

    @Test
    void testAddObject_WhenFileDoesNotExist() throws IOException {
        String FilePath= "src/data/data_Categorie.json";
        File file = new File(FilePath);

        if (file.exists()){
            file.delete();

        }
        CategorieRepository repo = new CategorieRepository();
        Categorie categorie = Categorie.builder()
                .categoryID(5)
                .categoryName("Lucia")
                .picture("null")
                .description("Aamarillo porque somos agiluchos")
                .build();

        repo.addObject(categorie);

        ObjectMapper mapper = new ObjectMapper();
        List<Categorie> category = List.of(mapper.readValue(file,Categorie[].class));

        assertEquals(1,category.size(),"debe haber tres categoria guardada");
        assertEquals(1,category.get(0).getCategoryID(),"debe haber una categoria guardada");


    }

}