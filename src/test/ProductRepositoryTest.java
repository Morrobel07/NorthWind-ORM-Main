package test;

import models.Product;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    void testListProducts() {
        ProductRepository repo = new ProductRepository();
        List<Product> list = repo.list();
        assertEquals(new ProductRepository().list(), list, "La lista no son del mismo tipo");
    }


}