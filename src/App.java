import com.fasterxml.jackson.databind.ObjectMapper;

import comons.SeedData;
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
import java.lang.classfile.ClassFile.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import comons.SeedData.*;
import models.Product;
import models.Shipper;
import repository.*;

public class App {
        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                String option;
                CategorieRepository categorieRep = new CategorieRepository();
                categorieRep.delete(50);
                do {
                        System.out.println("\n");
                        System.out.println("Bienvenido a la tienda de productos");
                        System.out.println("A continuación se le mostrará las opciones disponibles...");
                        System.out.println("1) Crear registros");
                        System.out.println("2)Eliminar registros");
                        System.out.println("3)Listar registros");
                        System.out.println("4) Salir");
                        System.out.print("Selecciona una opción ");
                        option = input.nextLine();

                        System.out.println("\n");

                        // MENU OPTION
                        switch (option) {
                                case "1": {
                                        Crud.CREATE.Create();
                                        break;

                                }
                                case "2": {

                                        break;

                                }
                                case "3": {

                                        System.out.println("Qué registro desea buscar ?");
                                        System.out.println(
                                                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                                        int find = input.nextInt();
                                        input.nextLine();
                                        switch (find) {
                                                case 1: {
                                                        System.out.println(
                                                                        "Ingresa el id del customer que desea encontrar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.CUSTOMER;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                // TODO: handle exception
                                                                System.out.println("Error al encontrar el id " + e);
                                                                return;
                                                        }

                                                }

                                                case 2: {
                                                        System.out.println(
                                                                        "Ingresa el id del Emplyee que desea encontrar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.EMPLOYEE;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al encontrar el id " + e);
                                                                return;
                                                        }

                                                }
                                                case 3: {
                                                        System.out.println(
                                                                        "Ingresa el id del Shipper que desea encontrar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.SHIPPER;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al encontrar el id " + e);
                                                                return;
                                                        }

                                                }
                                                case 4: {
                                                        System.out.println(
                                                                        "Ingresa el id del Order que desea buscar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.ORDER;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al ingresar el id " + e);
                                                                return;
                                                        }

                                                }
                                                case 5: {
                                                        System.out.println(
                                                                        "Ingresa el id del Supplier que deseas buscar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.SUPPLIER;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al encontrar el id " + e);
                                                                return;
                                                        }

                                                }
                                                case 6: {
                                                        System.out.println(
                                                                        "Ingresa el id del Categorie que desea buscar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.CATEGORIE;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al buscar el id " + e);
                                                                return;
                                                        }

                                                }
                                                case 7: {
                                                        System.out.println(
                                                                        "Ingresa el id del Product que desea buscar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.PRODUCT;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al buscar el id " + e);
                                                                break;
                                                        }

                                                }
                                                case 8: {
                                                        System.out.println(
                                                                        "Ingresa el id de la Order details que desea buscar");
                                                        try {
                                                                int id = input.nextInt();
                                                                input.nextLine();
                                                                listEntities list = listEntities.ORDER_DETAILS;
                                                                list.find(id);
                                                                break;
                                                        } catch (Exception e) {
                                                                System.out.println("Error al buscar el id " + e);
                                                                return;
                                                        }

                                                }

                                                default:

                                                        break;

                                        }
                                        break;

                                }
                                case "4": {
                                        System.out.println("Gracias por usar el sistema... saliendo");
                                        break;
                                }

                                default:

                                        System.out.println("ERROR AL ELEGIR UNA OPCÓN");

                                        break;
                        }

                } while (!"4".equals(option));
                input.close();

        }
}
