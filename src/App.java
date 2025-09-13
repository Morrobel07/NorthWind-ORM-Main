import com.fasterxml.jackson.databind.ObjectMapper;
import comons.SeedData;
import controllers.*;
import models.Customer;
import models.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import comons.SeedData.*;
import models.Product;
import repository.*;
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


        Customer custom = new Customer(
                1,"moroco","eeeee","EEEEE","boca canasta","Bani","peravia","94000",
                "Rd","00000000","klk"
        );

        Customer custom2 = new Customer(
                2,"moroco","eeeee","EEEEE","boca canasta","Bani","peravia","94000",
                "Rd","00000000","klk"
        );

        CustomerRepository cr = new CustomerRepository();
        CustomerController controler = new  CustomerController(cr);
        //controler.addCustomer(custom2);
        System.out.println(controler.getCustomerById("2"));










    }
}
