import com.fasterxml.jackson.databind.ObjectMapper;
import comons.SeedData;
import controllers.*;
import models.Categorie;
import models.Customer;
import models.Employee;
import models.MySupplier;
import models.Order;
import models.OrderDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import comons.SeedData.*;
import models.Product;
import models.Shipper;
import repository.*;
import repository.EmployeeRepository;

public class App {
        public static void main(String[] args) {

                System.out.println("Bienveido a la tienda de productos...\n");
                // Cliente
                Customer customer1 = new Customer(1, "webDevelopers", "Juan Perez", "Juan", "Calle Luna",
                                "Santo Domingo", "Distrito Nacional", "10101", "República Dominicana",
                                "8091234567", "0056789");
                // Empleado
                Employee empoyee1 = new Employee(1, "Gonzalez", "Maria", "Gerente de Ventas", "Sra.",
                                LocalDate.of(1985, 5, 15), LocalDate.of(2010, 3, 20), "Calle Sol",
                                "Santo Domingo", "Distrito Nacional", "10202",
                                "República Dominicana", "8097654321", "1234",
                                "maria.jpg", "Maria tiene 10 años de experiencia...", 0,
                                "/images/maria.jpg");
                // Envios
                Shipper shipper1 = new Shipper(1, "DHL", "8091112222");

                // Orden
                Order order1 = new Order(1, customer1, empoyee1, LocalDate.of(2023, 10, 1),
                                LocalDate.of(2023, 10, 5), LocalDate.of(2025, 8, 14), shipper1, 50.0,
                                "webDevelopers", "Calle Luna", "Santo Domingo", "Distrito Nacional",
                                "10101", "República Dominicana");
                // Proveedor
                MySupplier supplier1 = new MySupplier(1, "technoWorld", "Carlos Lopez", "Carlos", "Avenida central",
                                "Santo domingo", "Distrito Nacional", "10303", "República Dominicana",
                                "8092223333", "8092223334", "www.technoworld.com");
                // Categoria
                Categorie categorie1 = new Categorie(1, "Electrónica", "Dispositivos y gadgets electrónicos",
                                "electronics.jpg");
                // Producto
                Product product1 = new Product(1, "Laptop", supplier1, categorie1, "1 unit", 800.0, 50, 10, 5,
                                false);
                // Detalle de la orden
                OrderDetails orderDetails1 = new OrderDetails(order1, product1, 60.0, 2, 0.1);

                OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepository();
                OrderDetailsController orderDetailsController = new OrderDetailsController(orderDetailsRepository);

                // orderDetailsController.addOrderDetails(orderDetails1);

                System.out.println(orderDetailsController.getAllOrderDetails());

        }
}
