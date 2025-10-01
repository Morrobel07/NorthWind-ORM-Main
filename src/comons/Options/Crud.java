package comons.Options;

import java.util.Scanner;

import controllers.CategorieController;
import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.OrderController;
import controllers.OrderDetailsController;
import controllers.ProductController;
import controllers.ShipperController;
import controllers.SupplierController;
import models.Shipper;
import repository.CategorieRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.ShipperRepository;
import repository.SupplierRepository;

public enum Crud {
    CREATE, READ, UPDATE, DELETE;

    Scanner input = new Scanner(System.in);// ESTA CLASE MANEJA LAS OPERACIONES CREATE, READ, UPDATE Y DELETE !!

    public void options() {
        switch (this) {
            case CREATE: {

                // FIRST OPTION
                boolean condition;
                int entities = 0;
                do {
                    condition = false;

                    try {
                        System.out.println("Elige el registro que deseas crear");
                        System.out.println(// ENTIDADES
                                "1) Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order Details");
                        entities = Integer.parseInt(input.nextLine());

                    } catch (Exception e) {
                        System.out.print("\n*****ERROR! ");
                        System.out.println("Debes ingresar una opción válida");
                        condition = true;
                    }

                } while (condition);

                switch (entities) {
                    case 1: {// customer
                        if (new CustomerController(new CustomerRepository()).getAllCustomers().isEmpty()) {
                            System.out.println("\nNo hay una lista de Customer");
                        } else {
                            System.out.println("\n*****Lista de customer");
                            System.out.println(new CustomerController(new CustomerRepository()).getAllCustomers());

                        }
                        createEntities.CUSTOMER.create();

                        break;
                    }

                    case 2: {
                        if (new EmployeeController(new EmployeeRepository()).getAllEmployees().isEmpty()) {
                            System.out.println("\nNo hay una lista de Empleados");
                        } else {
                            System.out.println("\n*****Lista de Empleados");
                            System.out.println(new EmployeeController(new EmployeeRepository()).getAllEmployees());

                        }
                        createEntities.EMPLOYEE.create();

                        break;
                    }
                    case 3: {
                        if (new ShipperController(new ShipperRepository()).getAllShippers().isEmpty()) {
                            System.out.println("\nNo hay una lista de Shippers disponible");
                        } else {
                            System.out.println("\n*****Lista de Shippers");
                            System.out.println(new ShipperController(new ShipperRepository()).getAllShippers());

                        }

                        createEntities.SHIPPER.create();

                        break;
                    }
                    case 4: {
                        if (new OrderController(new OrderRepository()).getAllOrders().isEmpty()) {
                            System.out.println("\nNo hay una lista de Ordenes disponible");
                        } else {
                            System.out.println("\n*****Lista de Ordenes");
                            System.out.println(new OrderController(new OrderRepository()).getAllOrders());

                        }
                        createEntities.ORDER.create();

                        break;
                    }
                    case 5: {
                        if (new SupplierController(new SupplierRepository()).getAllSuppliers().isEmpty()) {
                            System.out.println("\nNo hay una lista de suplidores disponible");
                        } else {
                            System.out.println("\n*****Lista de suplidores");
                            System.out.println(new SupplierController(new SupplierRepository()).getAllSuppliers());

                        }
                        createEntities.SUPPLIER.create();

                        break;
                    }
                    case 6: {
                        if (new CategorieController(new CategorieRepository()).getAllCategories().isEmpty()) {
                            System.out.println("\nNo hay una lista de categoria disponible");
                        } else {
                            System.out.println("\n*****Lista de Categoria");
                            System.out.println(new CategorieController(new CategorieRepository()).getAllCategories());

                        }
                        createEntities.CATEGORIE.create();

                        break;

                    }
                    case 7: {
                        if (new ProductController(new ProductRepository()).getAllProducts().isEmpty()) {
                            System.out.println("\nNo hay una lista de Productos disponible");
                        } else {
                            System.out.println("\n*****Lista de productos");
                            System.out.println(new ProductController(new ProductRepository()).getAllProducts());

                        }
                        createEntities.PRODUCT.create();

                        break;

                    }
                    case 8: {// Order details
                        if (new OrderDetailsController(new OrderDetailsRepository()).getAllOrderDetails().isEmpty()) {
                            System.out.println("\nNo hay una lista de ordenes detalladas disponible");
                        } else {
                            System.out.println("\n*****Lista de Ordenes detalladas");
                            System.out.println(
                                    new OrderDetailsController(new OrderDetailsRepository()).getAllOrderDetails());

                        }
                        createEntities.ORDER_DETAILS.create();

                        break;
                    }

                    default:
                        System.out.print("\n*****ERROR! ");
                        System.out.println("debe elegir una opción válida");
                        break;
                }

                break;
            }
            case READ: {
                boolean condition1;
                int find = 0;
                do {
                    condition1 = false;

                    System.out.println("Qué registro desea buscar ?");
                    System.out.println(
                            "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                    try {

                        find = Integer.parseInt(input.nextLine());

                    } catch (Exception e) {
                        System.out.print("*****ERROR! ");
                        System.out.println("Debes ingresar una opción válida");
                        condition1 = true;
                    }

                } while (condition1);

                switch (find) {
                    case 1: {
                        listEntities.CUSTOMER.list(find);
                        break;
                    }
                    case 2: {
                        listEntities.EMPLOYEE.list(find);
                        break;
                    }
                    case 3: {
                        listEntities.SHIPPER.list(find);
                        break;
                    }
                    case 4: {
                        listEntities.ORDER.list(find);
                        break;
                    }
                    case 5: {
                        listEntities.SUPPLIER.list(find);
                        break;
                    }
                    case 6: {
                        listEntities.CATEGORIE.list(find);
                        break;
                    }
                    case 7: {
                        listEntities.PRODUCT.list(find);
                        break;
                    }
                    case 8: {
                        listEntities.ORDER_DETAILS.list(find);
                    }

                    default:
                        break;
                }

                break;
            }

            case DELETE: {

                System.out.println("Qué registro desea eliminar ?");
                System.out.println(
                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                int entities = 0;
                boolean validInput;
                do {
                    validInput = false;
                    System.out.println("Ingresar una opción válida:");
                    entities = Integer.parseInt(input.nextLine());
                    try {

                    } catch (Exception e) {
                        System.out.print("*****\nERROR! ");
                        System.out.println("Opción incorrecta");
                        validInput = true;
                    }

                } while (validInput);

                switch (entities) {

                    case 1: {
                        DeleteEntities.CUSTOMER.delete(entities);
                        break;
                    }

                    case 2: {
                        DeleteEntities.EMPLOYEE.delete(entities);
                        break;
                    }
                    case 3: {
                        DeleteEntities.SHIPPER.delete(entities);
                        break;
                    }
                    case 4: {
                        DeleteEntities.ORDER.delete(entities);
                        break;

                    }
                    case 5: {
                        DeleteEntities.SUPPLIER.delete(entities);
                        break;

                    }
                    case 6: {
                        DeleteEntities.CATEGORIE.delete(entities);
                        ;
                        break;
                    }
                    case 7: {
                        DeleteEntities.PRODUCT.delete(entities);
                        break;
                    }
                    case 8: {
                        DeleteEntities.ORDER_DETAILS.delete(entities);
                        break;
                    }

                    default:
                        System.out.print("\n*****ERROR! ");
                        System.out.println("Opción incorrecta...");
                        break;
                }
            }

            default:
                break;
        }
    }
}
