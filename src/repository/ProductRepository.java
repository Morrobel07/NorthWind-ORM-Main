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

public class EmployeeRepository implements IFile<Employee> {

    private static final String FilePath= "src/data/data_order.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT);
    public List<Employee> employees = new ArrayList<>();



    @Override
    public List<Employee> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Employee> employees)  {
        try {
            mapper.writeValue(new File(FilePath), employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee GetOne (String id) {
        List<Employee> employees = load();
        int employeeID = Integer.parseInt(id);
        Optional<Employee> results = employees.stream()
                .filter(c -> c.getEmployeeID() == employeeID).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<Employee> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Employee> employees = load();
        employees.removeIf(c -> c.getEmployeeID() == Integer.parseInt(id));
        Save(employees);
    }

    @Override
    public void Update(Employee entity) {
        List<Employee> employees = load();
       //int employeeID = Integer.parseInt(id);
        List<Employee> updatedEmployees = employees.stream()
                .map(c  -> c.getEmployeeID() == entity.getEmployeeID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedEmployees);

    }


}
