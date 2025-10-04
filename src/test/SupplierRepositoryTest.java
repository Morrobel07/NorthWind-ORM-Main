package test;

import models.Suppliers;
import org.junit.jupiter.api.Test;
import repository.SupplierRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupplierRepositoryTest {
    @Test
    void testListSuppliers() {
        SupplierRepository repo = new SupplierRepository();
        List<Suppliers> list = repo.list();
        assertEquals(new SupplierRepository().list(), list, "La lista no son del mismo tipo");
    }

}