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
import models.Employee;
import models.Order;

public class OrderRepository implements IFile<Order>   {

    private static final String FilePath= "src/data/data_order.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Order> orders = new ArrayList<>();



    @Override
    public List<Order> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Order>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Order> orders)  {
        try {
            mapper.writeValue(new File(FilePath), orders);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Order GetOne (String id) {
        List<Order> orders = load();
        int orderId = Integer.parseInt(id);
        Optional<Order> results = orders.stream()
                .filter(c -> c.getOrderID() == orderId).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<Order> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Order> employees = load();
        employees.removeIf(c -> c.getOrderID() == Integer.parseInt(id));
        Save(employees);
    }

    @Override
    public void Update(Order entity) {
        List<Order>  orders = load();
       //int employeeID = Integer.parseInt(id);
        List<Order> updatedEmployees = orders.stream()
                .map(c  -> c.getOrderID() == entity.getOrderID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedEmployees);

    }


}
