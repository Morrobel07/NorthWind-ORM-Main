package comons.Options;

import java.util.Scanner;

public enum Crud {
    CREATE, READ, UPDATE, DELETE;

    Scanner input = new Scanner(System.in);

    public void Create() {
        switch (this) {
            case CREATE: {
                // FIRST OPTION
                System.out.println("Elige el registro que deseas crear");

                System.out.println(// ENTIDADES
                        "1) Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order Details");
                String entities = input.nextLine();
                // TODO: ajustar creaciones
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
            case DELETE: {
                System.out.println("Qué registro desea eliminar ?");
                System.out.println(
                        "1)Customer 2)Employees 3)Shippers 4)Order 5)Supplier 6)Categorie 7)Product 8)Order details");
                int delete = input.nextInt();
                input.nextLine();
                switch (delete) {
                    // TODO: ajustar delete en App
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

            default:
                break;
        }
    }
}
