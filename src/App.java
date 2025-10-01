import com.fasterxml.jackson.databind.ObjectMapper;

import comons.Options.Crud;
import comons.Options.Crud.*;
import controllers.*;
import models.Categorie;
import models.Customer;
import models.Employee;
import models.Suppliers;
import models.Order;
import models.OrderDetails;
import comons.Options.listEntities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import models.Product;
import models.Shipper;
import repository.*;

public class App {
        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                String option;

                do {
                        System.out.println("\n");
                        System.out.println("Bienvenido a la tienda de productos");
                        System.out.println("A continuación se le mostrará las opciones disponibles...");
                        System.out.println("1) Crear registros");
                        System.out.println("2)Eliminar registros");
                        System.out.println("3)Listar registros");
                        System.out.println("4)Actualizar");
                        System.out.println("5) Salir");
                        System.out.print("Selecciona una opción ");
                        option = input.nextLine();

                        System.out.println("\n");

                        // MENU OPTION
                        switch (option) {
                                case "1": {
                                        Crud.CREATE.options();
                                        break;

                                }
                                case "2": {
                                        Crud.DELETE.options();
                                        break;

                                }
                                case "3": {

                                        Crud.READ.options();
                                        break;

                                }
                                case "4": {
                                        // TODO: realizar update en registros
                                        System.out.println("*****En proceso....");
                                        break;
                                }
                                case "5": {
                                        System.out.println("Gracias por usar el sistema... saliendo");
                                        break;
                                }

                                default:

                                        System.out.println("ERROR AL ELEGIR UNA OPCÓN");

                                        break;
                        }

                } while (!"5".equals(option));
                input.close();

        }
}
