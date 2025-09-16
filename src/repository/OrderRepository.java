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
import models.Categorie;
import models.Employee;
import models.Order;

public class OrderRepository implements IFile<Order,Integer>   {

    private static final String FilePath= "src/data/data_order.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());



    @Override
    public List<Order> list()    {
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
    public void persist(List<Order> orders)  {
        try {
            mapper.writeValue(new File(FilePath), orders);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Order entity) {
        List<Order> orders = list();

        for (Order e : orders) {
            if (e.getOrderID() == entity.getOrderID()) {
                System.out.println("No puedes realizar un duplicado del id " + entity.getOrderID());
                return;
            }

            orders.add(entity);
            persist(orders);
            System.out.println("Empleado agregado correctamente");
        }
    }


    @Override
    public Order findById (Integer id) {
        List<Order> orders = list();
        Optional<Order> results = orders.stream()
                .filter(c -> c.getOrderID() == id).findFirst();
        return results.orElse(null);
    }





    @Override
    public void delete(Integer id) {
        List<Order> employees = list();
        employees.removeIf(c -> c.getOrderID() == id);
        persist(employees);
    }

    @Override
    public void update(Order entity) {
        List<Order>  orders = list();
       //int employeeID = Integer.parseInt(id);
        List<Order> updatedEmployees = orders.stream()
                .map(c  -> c.getOrderID() == entity.getOrderID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedEmployees);

    }


}
