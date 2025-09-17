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
import models.*;
import models.Shipper;
import repository.*;
import repository.EmployeeRepository;

public class App {
        public static void main(String[] args) {


                Customer customer;
                Employee employee;
                Shipper shipper;
                Order order;
                MySupplier mySupplier;
                Categorie categorie;
                Product product;
                OrderDetails orderDetails;
                Scanner input = new Scanner(System.in);
                int option;

                do {
                        System.out.println("1) Crear registros");
                        System.out.println("2)Eliminar registros");
                        System.out.println("3)Listar registros");
                        System.out.println("4) Salir");
                        System.out.println("Selecciona una opción: ");
                        //System.out.println("\n");
                        option = Integer.parseInt(input.nextLine());
                        // MENU OPTION
                        switch (option) {
                                case 1: {// FIRST OPTION
                                        System.out.println("Elige el registro que deseas crear");
                                        System.out.println(// ENTIDADES
                                                        "1) Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order Details");
                                        String entities = input.nextLine();
                                        switch (entities) {
                                                case "1": {// customer
                                                        System.out.println("Ingresa el id del customer");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        System.out.println("Ingresa el nombre de la comopañía");
                                                        String companyName = input.nextLine();
                                                        System.out.println("Ingresa el nombre de contacto");
                                                        String contactName = input.nextLine();
                                                        System.out.println("Ingresa el titulo del contacto");
                                                        String contactTitle = input.nextLine();
                                                        System.out.println("Ingresa la dirección");
                                                        String address = input.nextLine();
                                                        System.out.println("Ingresa la ciudad");
                                                        String city = input.nextLine();
                                                        System.out.println("Ingresa la region");
                                                        String region = input.nextLine();
                                                        System.out.println("Ingresa codigo postal");
                                                        String postalCode = input.nextLine();
                                                        System.out.println("Ingresa el país");
                                                        String country = input.nextLine();
                                                        System.out.println("Ingresa el número de teléfono");
                                                        String phone = input.nextLine();
                                                        System.out.println("Ingresa el fax");
                                                        String fax = input.nextLine();

                                                        customer = new Customer.Builder()
                                                                        .customerID(id)
                                                                        .companyName(companyName)
                                                                        .contactName(contactName)
                                                                        .contactTitle(contactTitle)
                                                                        .address(address)
                                                                        .city(city)
                                                                        .region(region)
                                                                        .postalCode(postalCode)
                                                                        .country(country)
                                                                        .phone(phone)
                                                                        .fax(fax)
                                                                        .build();
                                                        // Método add para el backend
                                                        // se guarda el customer en esta linea
                                                        new CustomerController(new CustomerRepository()).addCustomer(customer);

                                                }

                                                        break;

                                                default:
                                                        break;
                                        }
                                }

                                        break;

                                default:
                                        break;
                        }

                } while (option != 4);
                input.close();

        }
}
