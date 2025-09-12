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

public class CustomerRepository implements IFile<Customer> {

    private static final String FilePath= "src/data/data_Customer.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Customer> customers = new ArrayList<>();



    @Override
    public List<Customer> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {

                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Customer>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Customer> customers)  {
        try {
            mapper.writeValue(new File(FilePath), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Customer GetOne (String id) {
        List<Customer> customers = load();
        int customerId = Integer.parseInt(id);
        Optional<Customer> results = customers.stream()
                .filter(c -> c.getCustomerID() == customerId).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<Customer> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Customer> customers = load();
        customers.removeIf(c -> c.getCustomerID() == Integer.parseInt(id));
        Save(customers);
    }

    @Override
    public void Update(Customer entity) {
        List<Customer> employees = load();
       //int employeeID = Integer.parseInt(id);
        List<Customer> updateCustomer = employees.stream()
                .map(c  -> c.getCustomerID() == entity.getCustomerID() ? entity : c)
                .collect(Collectors.toList());
        Save(updateCustomer);

    }


}
