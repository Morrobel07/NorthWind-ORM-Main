import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.EmployeeController;
import models.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import comons.SeedData;
import repository.EmployeeRepository;
import repository.EmployeeRepository;

public class App {
    public static void main(String[] args) {



        Employee emp = new Employee(

       2, "Fuller", "Andrew", "Vice President, Sales",
                             "Dr.", LocalDate.of(1952, 2, 19),
               LocalDate.of(1992, 8, 14), "908 W. Capital Way",
       "Tacoma", "WA", "98401",
     "USA", "(206) 555-9482", "3457",
       "Andrew received his BTS commercial...", "2",3,null

        );



        EmployeeRepository repo = new EmployeeRepository();

        EmployeeController employeeController = new EmployeeController(repo);

        System.out.println(employeeController.getAllEmployees().get(1));



















    }
}
