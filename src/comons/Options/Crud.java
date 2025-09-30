package comons.Options;

import java.util.Scanner;

import repository.CustomerRepository;

public enum Crud {
    CREATE, READ, UPDATE, DELETE;

    Scanner input = new Scanner(System.in);

    public void options() {
        switch (this) {
            case CREATE: {
                // FIRST OPTION
                System.out.println("Elige el registro que deseas crear");

                System.out.println(// ENTIDADES
                        "1) Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order Details");
                String entities = input.nextLine();

                switch (entities) {
                    case "1": {// customer
                        createEntities.CUSTOMER.create();

                        break;
                    }

                    case "2": {
                        createEntities.EMPLOYEE.create();

                        break;
                    }
                    case "3": {
                        createEntities.SHIPPER.create();

                        break;
                    }
                    case "4": {
                        createEntities.ORDER.create();

                        break;
                    }
                    case "5": {
                        createEntities.SUPPLIER.create();

                        break;
                    }
                    case "6": {
                        createEntities.CATEGORIE.create();

                        break;

                    }
                    case "7": {
                        createEntities.PRODUCT.create();

                        break;

                    }
                    case "8": {// Order details
                        createEntities.ORDER_DETAILS.create();

                        break;
                    }

                    default:
                        System.out.print("\n*****HERROR! ");
                        System.out.println("debe elegir una opción válida");
                        break;
                }

                break;
            }
            case READ: {

                break;
            }
            // TODO: ajustar delet
            case DELETE: {

                System.out.println("Qué registro desea eliminar ?");
                System.out.println(
                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                int entities = 0;
                boolean validInput;
                do {
                    System.out.println("Ingresar una opción válida:");
                    String entrada = input.nextLine().trim(); // elimina espacios

                    if (entrada.matches("[0-9]+")) {
                        entities = Integer.parseInt(entrada);
                        validInput = false;
                    } else {
                        System.out.println("*****HERROR! Debe ingresar un número entero válido");
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
                        System.out.print("\n*****HERROR! ");
                        System.out.println("Opción incorrecta...");
                        break;
                }
            }

            default:
                break;
        }
    }
}
