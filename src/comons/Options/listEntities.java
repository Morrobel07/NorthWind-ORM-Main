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

import repository.CategorieRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.ShipperRepository;
import repository.SupplierRepository;

public enum listEntities {
    CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

    Scanner input = new Scanner(System.in);

    public void list(int id) {

        switch (this) {

            case CUSTOMER: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id del customer que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new CustomerRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new CustomerRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;
            }

            case EMPLOYEE: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id del Empleado que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new EmployeeRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new EmployeeRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;

            }
            case SHIPPER: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id del Shipper que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new ShipperRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new ShipperRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;

            }
            case ORDER: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id de la Orden que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new OrderRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new OrderRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;
            }
            case SUPPLIER: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id del Suplidor que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new SupplierRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new SupplierRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;

            }
            case CATEGORIE: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id de la Categoria que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new CategorieRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new CategorieRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;
            }
            case PRODUCT: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id del Producto que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new ProductRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new ProductRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;
            }
            case ORDER_DETAILS: {
                boolean condition;
                do {
                    condition = false;
                    try {
                        System.out.println(
                                "Ingresa el id de la orden detallada que desea encontrar");
                        id = Integer.parseInt(input.nextLine());

                        if (new OrderDetailsRepository().findById(id) == null) {
                            System.out.print("\n*****ERROR! ");
                            System.out.println("El id no existe");
                            condition = true;
                        }

                        System.out.println(new OrderDetailsRepository().findById(id));

                    } catch (Exception e) {

                        System.out.println("\n*****ERROR! ");
                        System.out.println("has ingresado un valor incorrecto");
                        condition = true;
                    }

                } while (condition);
                break;
            }

            default:
                System.out.println("Opción incorrecta");
                break;

        }
    }
}
