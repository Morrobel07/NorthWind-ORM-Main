package comons;

import models.*;
import repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeedData {
    private static EmployeeRepository repoE = new EmployeeRepository();
    private static SupplierRepository repoS = new SupplierRepository();
    private static ShipperRepository repoShiper = new ShipperRepository();
    private static ProductRepository repoProduct = new ProductRepository();
    private static OrderDetailsRepository repoOrderDetails = new OrderDetailsRepository();
    private static OrderRepository repoOrder = new OrderRepository();
    private static CategorieRepository repoCategorie = new CategorieRepository();
    private static CustomerRepository repoCustomer = new CustomerRepository();


    public List<Employee> seedDataEmployees() {

        List<Employee> employees = repoE.GetAll();
        if (employees.isEmpty()) {
            employees.add(
                    new Employee(
                            1, "Davolio", "Nancy", "Sales Representative", "Shipero",
                            LocalDate.of(1968, 12, 8),
                            LocalDate.of(1992, 5, 1), "507 - 20th Ave. E. Apt. 2A",
                            "Seattle", "WA", "98122",
                            "USA", "(206) 555-9857", "5467",
                            "Education includes a BA in psychology...", "2", 3, null
                    )


            );
            repoE.Save(employees);
        } else {
            System.out.println("Ya existen empleados");
        }
        return employees;
    }

    public List<Supplier> seedDataSuppliers() {
        List<Supplier> suppliers = repoS.GetAll();
        if (suppliers.isEmpty()) {
            suppliers.add(
                    new Supplier(
                            1, "Exotic Liquid", "Charlotte Cooper", "Purchasing Manager ",
                            "49Gilbert St.", "London", null, "EC1 4SD", "UK",
                            "(171) 555-2222", null, null
                    )
            );
            repoS.Save(suppliers);

        } else {

            System.out.println("Ya existen Suppliers");
        }
        return suppliers;
    }

    public List<Shipper> seedDAtaShipper() {
        List<Shipper> shippers = repoShiper.GetAll();

        if (shippers.isEmpty()) {
            shippers.add(
                    new Shipper(
                            1, "Speedy Express", "Thomasecd"
                    )
            );
            repoShiper.Save(shippers);

        } else {
            System.out.println("Ya existen shippers");
        }
        return shippers;
    }

    public List<Product> seedDataProduct() {
        List<Product> products = repoProduct.load();


         {
            products.add(
                    new Product(
                            1, "Chais", null, null, "10 boxes x 20 bags", 18.00, 100, 0, 10,
                            false
                    )
            );
            repoProduct.Save(products);
        }
        return products;

    }

    public List<OrderDetails> seedDataOrderDetails() {
        List<OrderDetails> orderDetails = repoOrderDetails.load();
        if (orderDetails.isEmpty()) {
            orderDetails.add(
                    new OrderDetails(
                            null, null, 19.45, 5, 0
                    )
            );
            repoOrderDetails.Save(orderDetails);
        } else {
            System.out.println("Ya existen order details");
        }

        return orderDetails;
    }

    public List<Order> seedDataOrder() {
        List<Order> orders = repoOrder.load();
        if (orders.isEmpty()) {
            orders.add(
                    new Order(
                            1, null, null, null, null, null, null, 0, null, null, null, null, null, null
                    )
            );
            repoOrder.Save(orders);
        } else {
            System.out.println("Ya existen orders");
        }

        return orders;
    }

    public List<Categorie> seedDataCategorie() {
        List<Categorie> categories = repoCategorie.load();
        if (categories.isEmpty()) {
            categories.add(
                    new Categorie(
                            1, "Beverages", "Soft drinks, coffees, teas, beers, and ales", null
                    )
            );
            repoCategorie.Save(categories);
        }else {
            System.out.println("Ya existen Categories");
        }
        return categories;
    }

    public List<Customer> seedDataCustomer() {
        List<Customer> customers = repoCustomer.load();
        if (customers.isEmpty()) {
            customers.add(
                    new Customer(
                            1, "Alfreds Futterkiste", "Maria Anders", "Sales Representative", "Obere Str. 57", "Berlin", null,
                            "12209", "Germany", "030-0074321", "030-00"
                    )
            );
            repoCustomer.Save(customers);

        } else {
            System.out.println("Ya existen customers");
        }
        return customers;
    }

}





