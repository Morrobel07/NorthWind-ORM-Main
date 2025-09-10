package comons;

import models.Employee;
import repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeedData {

     private static final EmployeeRepository repo = new EmployeeRepository();



    public static void seedDataEmployees( ) {

        List<Employee> employees = repo.GetAll();



        if (employees.isEmpty()){
            employees.add(
                    new Employee(
                            1, "Davolio", "Nancy", "Sales Representative","Shipero",
                              LocalDate.of(1968, 12, 8),
                             LocalDate.of(1992, 5, 1), "507 - 20th Ave. E. Apt. 2A",
                             "Seattle", "WA", "98122",
                              "USA", "(206) 555-9857", "5467",
                               "Education includes a BA in psychology...", "2", 3,null
                    )


            ); repo.Save(employees);
        } else {
            System.out.println("Ya existen empleados");
        }






    }
}

//List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(
//        1, "Davolio", "Nancy", "Sales Representative",
//                              "Ms.", LocalDate.of(1968, 12, 8),
//                LocalDate.of(1992, 5, 1), "507 - 20th Ave. E. Apt. 2A",
//        "Seattle", "WA", "98122",
//        "USA", "(206) 555-9857", "5467",
//        "Education includes a BA in psychology...", "2", 3,null
//        ));
//
//
//
//        employees.add(new Employee(
//        3, "Leverling", "Janet", "Sales Representative",
//                              "Ms.", LocalDate.of(1963, 8, 30),
//                LocalDate.of(1992, 4, 1), "722 S. Capital Way",
//        "Tacoma", "WA", "98401",
//        "USA", "(206) 555-3412", "3355",
//        "Janet has a BS in chemistry...", "2", 4,null
//        ));