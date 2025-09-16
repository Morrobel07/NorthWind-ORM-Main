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
import models.OrderDetails;

public class OrderDetailsRepository implements IFile<OrderDetails,Integer> {

    private static final String FilePath = "src/data/data_OrderDetails.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Employee> employees = new ArrayList<>();

    @Override
    public List<OrderDetails> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<OrderDetails>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist (List<OrderDetails> orderDetails) {
        try {
            mapper.writeValue(new File(FilePath), orderDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(OrderDetails entity) {
        List<OrderDetails> orderDetails = list();

        for (OrderDetails e : orderDetails) {
            if (e.getOrderID() == entity.getOrderID()) {
                System.out.println("No puedes realizar un duplicado del id " + entity.getOrderID());
                return;
            }

            orderDetails.add(entity);
            persist(orderDetails);
            System.out.println("Empleado agregado correctamente");
        }
    }

    @Override
    public OrderDetails findById(Integer id) {
        List<OrderDetails> ordersDetails = list();
        Optional<OrderDetails> results = ordersDetails.stream()
                .filter(c -> c.getOrderID().equals(id)).findFirst();
        return results.orElse(null);
    }



    @Override
    public void delete(Integer id) {
        List<OrderDetails> orderDetails = list();
        orderDetails.removeIf(c -> c.getOrderID().equals(id));
        orderDetails.clear();
        persist(orderDetails);
    }

    @Override
    public void update(OrderDetails entity) {
        List<OrderDetails> orderDetails = list();
        List<OrderDetails> updateOrderDetails = orderDetails.stream()
                .map(c -> c.getOrderID() == entity.getOrderID() ? entity : c)
                .collect(Collectors.toList());
        persist(updateOrderDetails);

    }

}
