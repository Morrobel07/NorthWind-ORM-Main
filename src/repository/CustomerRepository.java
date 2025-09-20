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
import models.Categorie;
import models.Customer;
import models.Employee;

public class CustomerRepository implements IFile<Customer,Integer> {

    private static final String FilePath = "src/data/data_Customer.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public List<Customer> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {

                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Customer>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist(List<Customer> customers) {

        try {
            mapper.writeValue(new File(FilePath), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addObject(Customer entity) {
        List<Customer> customers = list();

        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerID() ==(entity.getCustomerID())) {
                System.out.println("Error: Ya existe un cliente con el ID " + entity.getCustomerID());
                return;
            }
        }

        customers.add(entity);
        persist(customers);
        System.out.println("Cliente agregado correctamente.");
    }

    @Override
    public Customer findById(Integer id) {
        List<Customer> customers = list();
        Optional<Customer> results = customers.stream()
                .filter(c -> c.getCustomerID() == id).findFirst();
        return results.orElse(null);
    }



    @Override
    public void delete(Integer id) {
        List<Customer> customers = list();
        customers.removeIf(c -> c.getCustomerID() == id);
        persist(customers);
    }

    @Override
    public void update(Customer entity) {
        List<Customer> employees = list();
        List<Customer> updateCustomer = employees.stream()
                .map(c -> c.getCustomerID() == entity.getCustomerID() ? entity : c)
                .collect(Collectors.toList());
        persist(updateCustomer);

    }

}
