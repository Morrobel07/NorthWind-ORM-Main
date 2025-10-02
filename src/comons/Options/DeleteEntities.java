package comons.Options;

import java.util.Scanner;

import repository.CategorieRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.ShipperRepository;
import repository.SupplierRepository;

public enum DeleteEntities {
    CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

    Scanner input = new Scanner(System.in);

    public void delete(int id) {
        switch (this) {
            case CUSTOMER: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del customer que desea eliminar");
                        // utilizo la misma variable 'entities' para capturar la entrada
                        id = input.nextInt();
                        input.nextLine();
                        if (new CustomerRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new CustomerRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case EMPLOYEE: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del Employee que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new EmployeeRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new EmployeeRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);

                break;
            }
            case SHIPPER: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del Shipper que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new ShipperRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new ShipperRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case ORDER: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del order que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new OrderRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new OrderRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case SUPPLIER: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del supplier que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new SupplierRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new SupplierRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case CATEGORIE: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del categorie que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new CategorieRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new CategorieRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case PRODUCT: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del Product que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new ProductRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new ProductRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }
            case ORDER_DETAILS: {
                boolean condition;
                do {
                    try {
                        System.out.println(
                                "Ingresa el id del Shipper que desea eliminar");
                        id = input.nextInt();
                        input.nextLine();
                        if (new OrderDetailsRepository().findById(id) != null) {
                            System.out.println("*****Eliminando registro!");
                            new OrderDetailsRepository().delete(id);
                            condition = false;
                        } else {
                            System.out.print("\n*****HERROR ");
                            System.out.println("El id que intenta eliminar no existe");
                            condition = true;
                        }

                    } catch (Exception e) {
                        System.out.print("*****!HERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine();
                    }

                } while (condition);
                break;
            }

            default:
                break;
        }
    }
}
