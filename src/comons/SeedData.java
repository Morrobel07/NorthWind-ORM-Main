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
                    new Employee.Builder()
                            .employeeID(1)
                            .address("Santome con capotillo")
                            .birthDate(LocalDate.of(2000, 9, 3))
                            .country("Puerto Rico")
                            .city("Maracaibo")
                            .firstName("Juan")
                            .lastName("Sanchez")
                            .hireDate(LocalDate.of(2015, 10, 8))
                            .homePhone("5096854567")
                            .postalCode("94000")
                            .build()

            );
            repoE.Save(employees);
        } else {
            System.out.println("Ya existen empleados");
        }
        return employees;
    }

    public List<MySupplier> seedDataSuppliers() {
        List<MySupplier> suppliers = repoS.GetAll();
        if (suppliers.isEmpty()) {
            suppliers.add(
                    new MySupplier.Builder()
                            .companyName("Fedex")
                            .contactName("Gerardo fedex")
                            .contactTitle("Gerardo")
                            .homePage("fedex.com")
                            .address("esquina Kenedy")
                            .fax("5068742")
                            .build());
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
                    new Shipper.Builder()
                            .companyName("shipperExpress")
                            .phone("8059452454")
                            .shipperID(0)
                            .build());
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
                    new Product.Builder()
                            .productID(0)
                            .productName(null)
                            .categoryID(null)
                            .discontinued(false)
                            .build());
            repoProduct.Save(products);
        }
        return products;

    }

    public List<OrderDetails> seedDataOrderDetails() {
        List<OrderDetails> orderDetails = repoOrderDetails.load();
        if (orderDetails.isEmpty()) {
            orderDetails.add(
                    new OrderDetails.Builder()
                            .orderID(null)
                            .productID(null)
                            .discount(5.50)
                            .unitPrice(25.99)
                            .build());
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
                    new Order.Builder()
                            .customersID(null)
                            .employeeID(null)
                            .freight(5.0)
                            .shipAddress("Fedex")
                            .requiredDate(LocalDate.of(2026, 1, 25))
                            .shipCity("Baní")
                            .build());
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
                    new Categorie.Builder()
                            .categoryID(1)
                            .categoryName("Emparedado")
                            .description("Tecnologia")
                            .picture("Foto.png")
                            .build());
            repoCategorie.Save(categories);
        } else {
            System.out.println("Ya existen Categories");
        }
        return categories;
    }

    public List<Customer> seedDataCustomer() {
        List<Customer> customers = repoCustomer.load();
        if (customers.isEmpty()) {
            customers.add(
                    new Customer.Builder()
                            .companyName("Developers")
                            .phone("8095226321")
                            .city("San jose ocoa")
                            .postalCode("94000")
                            .contactName("Yimi")
                            .region("Azua")
                            .address("Las mercedez #17")
                            .country("Rep. Dom.")
                            .contactTitle("DevelopesApp")
                            .build());
            repoCustomer.Save(customers);

        } else {
            System.out.println("Ya existen customers");
        }
        return customers;
    }

}
