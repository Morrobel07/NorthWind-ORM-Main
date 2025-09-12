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
import models.OrderDetails;

public class OrderDetailsRepository implements IFile<OrderDetails> {

    private static final String FilePath= "src/data/data_OrderDetails.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Employee> employees = new ArrayList<>();




    @Override
    public List<OrderDetails> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<OrderDetails>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<OrderDetails> orderDetails)  {
        try {
            mapper.writeValue(new File(FilePath), orderDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public OrderDetails GetOne (String id) {
        List<OrderDetails> ordersDetails = load();
        //int orderDetailsID = Integer.parseInt(id);
        Optional<OrderDetails> results = ordersDetails.stream()
                .filter(c -> c.getOrderID().equals(id)).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<OrderDetails> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<OrderDetails>  orderDetails = load();
        orderDetails.removeIf(c -> c.getOrderID().equals(id));
        Save(orderDetails);
    }

    @Override
    public void Update(OrderDetails entity) {
        List<OrderDetails> orderDetails = load();
       //int employeeID = Integer.parseInt(id);
        List<OrderDetails> updateOrderDetails = orderDetails.stream()
                .map(c  -> c.getOrderID() == entity.getOrderID() ? entity : c)
                .collect(Collectors.toList());
        Save(updateOrderDetails);

    }


}
