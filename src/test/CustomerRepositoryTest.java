package test;

import controllers.CategorieController;
import controllers.CustomerController;
import models.Categorie;
import models.Customer;
import org.junit.jupiter.api.Test;
import repository.CategorieRepository;
import repository.CustomerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    @Test
    void testListCategories() {

        CustomerRepository repo = new CustomerRepository();
        List<Customer> list = repo.list();
        assertEquals(new CustomerController(new CustomerRepository()).getAllCustomers(), list,"alista no son del mismo tipo");


    }

}