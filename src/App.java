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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import comons.SeedData.*;
import models.Product;
import models.Shipper;
import recordsEntities.*;
import repository.*;

public class App {
        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                int option;

                do {
                        System.out.println("\n");
                        System.out.println("Bienvenido a la tienda de productos");
                        System.out.println("1) Crear registros");
                        System.out.println("2)Eliminar registros");
                        System.out.println("3)Listar registros");
                        System.out.println("4) Salir");
                        System.out.print("Selecciona una opción ");
                        option = Integer.parseInt(input.nextLine());
                        System.out.println("\n");

                        // MENU OPTION
                        switch (option) {
                                case 1: {// FIRST OPTION
                                        System.out.println("Elige el registro que deseas crear");
                                        System.out.println(
                                                        "Es necesario ingresarlos en el orden que se presenta debajo si no hay registros creados");
                                        System.out.println(// ENTIDADES
                                                        "1) Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order Details");
                                        String entities = input.nextLine();
                                        switch (entities) {
                                                case "1": {// customer
                                                        createEntities createEntity = createEntities.CUSTOMER;
                                                        createEntity.crear();
                                                        break;

                                                }

                                                case "2": {
                                                        createEntities createEntiity = createEntities.EMPLOYEE;
                                                        createEntiity.crear();
                                                        break;
                                                }
                                                case "3": {
                                                        createEntities createEntity = createEntities.SHIPPER;
                                                        createEntity.crear();
                                                        break;
                                                }
                                                case "4": {
                                                        createEntities createEntity = createEntities.ORDER;
                                                        createEntity.crear();
                                                        break;
                                                }
                                                case "5": {
                                                        createEntities creatEntity = createEntities.SUPPLIER;
                                                        creatEntity.crear();
                                                        break;
                                                }
                                                case "6": {
                                                        createEntities creatEntity = createEntities.CATEGORIE;
                                                        creatEntity.crear();
                                                        break;

                                                }
                                                case "7": {
                                                        createEntities creatEntity = createEntities.PRODUCT;
                                                        creatEntity.crear();
                                                        break;

                                                }
                                                case "8": {// Order details
                                                        createEntities creatEntity = createEntities.ORDER_DETAILS;
                                                        creatEntity.crear();
                                                        break;
                                                }

                                                default:
                                                        break;
                                        }

                                        break;

                                }
                                case 2: {
                                        System.out.println("Qué registro desea eliminar ?");
                                        System.out.println(
                                                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                                        int delete = input.nextInt();
                                        input.nextLine();
                                        switch (delete) {
                                                case 1: {
                                                        System.out.println(
                                                                        "Ingresa el id del customer que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.CUSTOMER;
                                                        register.delete(id);
                                                        break;
                                                }

                                                case 2: {
                                                        System.out.println(
                                                                        "Ingresa el id del Emplyee que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.EMPLOYEE;
                                                        register.delete(id);
                                                        break;
                                                }
                                                case 3: {
                                                        System.out.println(
                                                                        "Ingresa el id del Shipper que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.SHIPPER;
                                                        register.delete(id);
                                                        break;
                                                }
                                                case 4: {
                                                        System.out.println(
                                                                        "Ingresa el id del Order que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.ORDER;
                                                        register.delete(id);
                                                        break;

                                                }
                                                case 5: {
                                                        System.out.println(
                                                                        "Ingresa el id del Supplier que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.SUPPLIER;
                                                        register.delete(id);
                                                        break;

                                                }
                                                case 6: {
                                                        System.out.println(
                                                                        "Ingresa el id del Categorie que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.CATEGORIE;
                                                        register.delete(id);
                                                        break;
                                                }
                                                case 7: {
                                                        System.out.println(
                                                                        "Ingresa el id del Product que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.PRODUCT;
                                                        register.delete(id);
                                                        break;
                                                }
                                                case 8: {
                                                        System.out.println(
                                                                        "Ingresa el id de la Order details que desea eliminar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        entitiesDelete register = entitiesDelete.ORDER_DETAILS;
                                                        register.delete(id);
                                                        break;
                                                }

                                                default:
                                                        break;
                                        }

                                }
                                case 3: {

                                        System.out.println("Qué registro desea buscar ?");
                                        System.out.println(
                                                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                                        int find = input.nextInt();
                                        input.nextLine();
                                        switch (find) {
                                                case 1: {
                                                        System.out.println(
                                                                        "Ingresa el id del customer que desea encontrar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.CUSTOMER;
                                                        list.find(id);
                                                        break;
                                                }

                                                case 2: {
                                                        System.out.println(
                                                                        "Ingresa el id del Emplyee que desea encontrar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.EMPLOYEE;
                                                        list.find(id);
                                                        break;
                                                }
                                                case 3: {
                                                        System.out.println(
                                                                        "Ingresa el id del Shipper que desea encontrar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.SHIPPER;
                                                        list.find(id);
                                                        break;
                                                }
                                                case 4: {
                                                        System.out.println(
                                                                        "Ingresa el id del Order que desea buscar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.ORDER;
                                                        list.find(id);
                                                        break;

                                                }
                                                case 5: {
                                                        System.out.println(
                                                                        "Ingresa el id del Supplier que deseas buscar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.SUPPLIER;
                                                        list.find(id);
                                                        break;

                                                }
                                                case 6: {
                                                        System.out.println(
                                                                        "Ingresa el id del Categorie que desea buscar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.CATEGORIE;
                                                        list.find(id);
                                                        break;
                                                }
                                                case 7: {
                                                        System.out.println(
                                                                        "Ingresa el id del Product que desea buscar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.PRODUCT;
                                                        list.find(id);
                                                        break;
                                                }
                                                case 8: {
                                                        System.out.println(
                                                                        "Ingresa el id de la Order details que desea buscar");
                                                        int id = input.nextInt();
                                                        input.nextLine();
                                                        listEntities list = listEntities.ORDER_DETAILS;
                                                        list.find(id);
                                                        break;
                                                }

                                                default:
                                                        break;
                                        }
                                }

                                default:
                                        System.out.println("Error al elegir una opción");
                                        break;
                        }

                } while (option != 4);
                input.close();

        }
}
