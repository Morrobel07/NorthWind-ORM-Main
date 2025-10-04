package test;

import controllers.CategorieController;
import models.Categorie;
import org.junit.jupiter.api.Test;
import repository.CategorieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategorieRepositoryTest {

    @Test
    void testListCategories() {

        CategorieRepository repo = new CategorieRepository();
        List<Categorie> list = repo.list();
        assertEquals(new CategorieController(new CategorieRepository()).getAllCategories(), list,"alista no son del mismo tipo");


    }

}