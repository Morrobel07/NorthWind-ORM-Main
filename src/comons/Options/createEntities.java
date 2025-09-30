package comons.Options;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controllers.CategorieController;
import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.OrderController;
import controllers.OrderDetailsController;
import controllers.ProductController;
import controllers.ShipperController;
import controllers.SupplierController;
import models.Categorie;
import models.Customer;
import models.Employee;
import models.Suppliers;
import models.Order;
import models.OrderDetails;
import models.Product;
import models.Shipper;
import repository.CategorieRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.ShipperRepository;
import repository.SupplierRepository;

public enum createEntities {
        CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

        Customer customer;
        Employee employee;
        Shipper shipper;
        Order order;
        Suppliers mySupplier;
        Categorie categorie;
        Product product;
        OrderDetails orderDetails;
        Validations validate = new Validations();

        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");

        public void create() {
                switch (this) {
                        case CUSTOMER: {
                                // validando nombre
                                String companyName;
                                do {
                                        System.out.println("Ingresa el nombre de la comopañía");
                                        companyName = input.nextLine();
                                } while (!validate.validationsStrings(companyName));

                                String contactName;
                                do {
                                        System.out.println("Ingresa el nombre de contacto");
                                        contactName = input.nextLine();
                                } while (!validate.validationsStrings(contactName));

                                String contactTitle;
                                do {
                                        System.out.println("Ingresa el titulo del contacto");
                                        contactTitle = input.nextLine();
                                } while (!validate.validationsStrings(contactTitle));

                                String city;
                                do {
                                        System.out.println("Ingresa la ciudad");
                                        city = input.nextLine();
                                } while (!validate.validationsStrings(city));

                                String region;
                                do {
                                        System.out.println("Ingresa la region");
                                        region = input.nextLine();
                                } while (!validate.validationsStrings(region));

                                String country;
                                do {
                                        System.out.println("Ingresa el país");
                                        country = input.nextLine();
                                } while (!validate.validationsStrings(country));

                                String address;
                                do {
                                        System.out.println("Ingresa la dirección");
                                        address = input.nextLine();
                                } while (!validate.addressValidations(address));

                                String postalCode;
                                do {
                                        System.out.println("Ingresa codigo postal");
                                        postalCode = input.nextLine();
                                } while (!validate.postalCodeValidations(postalCode));

                                String phone;
                                do {
                                        System.out.println("Ingresa el número de teléfono");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                String fax;
                                do {
                                        System.out.println("Ingresa el fax");
                                        fax = input.nextLine();
                                } while (!validate.numberPhoneValidations(fax));

                                customer = new Customer.Builder()
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
                                new CustomerController(new CustomerRepository())
                                                .addCustomer(customer);
                                // ERROR MORROBEL

                                break;
                        }
                        case EMPLOYEE: {

                                String lastName;
                                do {
                                        System.out.println("Ingresa el apellido");
                                        lastName = input.nextLine();
                                } while (!validate.validationsStrings(lastName));

                                String name;
                                do {
                                        System.out.println("Ingresar Nombre");
                                        name = input.nextLine();
                                } while (!validate.validationsStrings(name));

                                String title;
                                do {
                                        System.out.println("Ingresa el titulo");
                                        title = input.nextLine();
                                } while (!validate.validationsStrings(title));

                                String titleOfcourtesy;
                                do {
                                        System.out.println("Ingresa el title Of courtesy");
                                        titleOfcourtesy = input.nextLine();
                                } while (!validate.validationsStrings(titleOfcourtesy));

                                LocalDate birtDate = null;
                                LocalDate hireDate = null;
                                boolean condition;
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresar su fecha de cumpleaños (orden del formato: 31/12/1999)");
                                                birtDate = LocalDate.parse(input.nextLine(), formatter);
                                                System.out.println("Ingresa fecha de contrato");
                                                hireDate = LocalDate.parse(input.nextLine(), formatter);
                                                condition = false;
                                        } catch (Exception e) {
                                                System.out.println("\n*****HERROR! ");
                                                System.out.println("Formato de fecha incorrecta");
                                                condition = true;

                                        }
                                } while (condition);

                                String address;
                                do {
                                        System.out.println("Ingresar su dirección");
                                        address = input.nextLine();
                                } while (!validate.addressValidations(address));

                                String city;
                                do {
                                        System.out.println("Ingresar la ciudad");
                                        city = input.nextLine();
                                } while (!validate.validationsStrings(city));

                                String region;
                                do {
                                        System.out.println("Ingrear la region");
                                        region = input.nextLine();
                                } while (!validate.validationsStrings(region));

                                String postalCode;
                                do {
                                        System.out.println("ingresar el código postal");
                                        postalCode = input.nextLine();
                                } while (!validate.postalCodeValidations(postalCode));

                                String country;
                                do {
                                        System.out.println("Ingresar país");
                                        country = input.nextLine();
                                } while (!validate.validationsStrings(country));

                                String phone;
                                do {
                                        System.out.println("Ingresar número de telefono");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                String extension;
                                do {
                                        System.out.println("Ingresar la extension");
                                        extension = input.nextLine();
                                } while (!validate.extensionNumber(extension));

                                // foto

                                String note;
                                do {
                                        System.out.println("Ingresar Nota");
                                        note = input.nextLine();
                                } while (!validate.validationsStrings(note));

                                employee = new Employee.Builder()

                                                .lastName(lastName)
                                                .firstName(name)
                                                .title(title)
                                                .titleOfCourtesy(titleOfcourtesy)
                                                .birthDate(birtDate)
                                                .hireDate(hireDate)
                                                .address(address)
                                                .city(city)
                                                .postalCode(postalCode)
                                                .country(country)
                                                .homePhone(phone)
                                                .extension(extension)
                                                // foto
                                                .notes(note)
                                                .region(region)
                                                .build();
                                new EmployeeController(new EmployeeRepository())
                                                .addEmployee(employee);
                                break;
                        }
                        case SHIPPER: {
                                String companyName;
                                do {
                                        System.out.println("Ingresar nombre del Shipper");
                                        companyName = input.nextLine();
                                } while (!validate.validationsStrings(companyName));

                                String phone;
                                do {
                                        System.out.println("Ingresar el número de teléfono");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                shipper = new Shipper.Builder()

                                                .companyName(companyName)
                                                .phone(phone)
                                                .build();
                                // agregando al backend
                                new ShipperController(new ShipperRepository())
                                                .addShipper(shipper);
                                break;
                        }
                        case ORDER: {

                                int findCustomerId;
                                boolean condition1;
                                Customer customerId = null;
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresar el id del customer a quien pertenece esta orden");
                                                findCustomerId = input.nextInt();
                                                input.nextLine();
                                                condition1 = false;
                                                // buscando el objeto Customer que tenga el mismo id que ingresó
                                                // el usuario
                                                CustomerRepository customerRepository = new CustomerRepository();
                                                CustomerController customerController = new CustomerController(
                                                                customerRepository);
                                                customerId = customerController
                                                                .getCustomerById(findCustomerId);

                                                if (customerId == null) {
                                                        System.out.print("\n*****HERROR! ");
                                                        System.out.println("El id igresado no existe");
                                                        condition1 = true;
                                                }

                                        } catch (Exception e) {

                                                System.out.print("\n*****HERROR! ");
                                                System.out.println("Herror al ingresar un id válido");
                                                condition1 = true;
                                                input.nextLine();

                                        }
                                } while (condition1);

                                boolean condition2;
                                int findEmployeeid;
                                Employee employeeId = null;
                                do {

                                        try {
                                                System.out.println(
                                                                "Ingresar el id del empleado quien realiza la Orden de compra");

                                                findEmployeeid = input.nextInt();
                                                input.nextLine();
                                                condition2 = false;
                                                // Buscando el objeto Employee por su id
                                                EmployeeRepository employeeRepository = new EmployeeRepository();
                                                EmployeeController employeeController = new EmployeeController(
                                                                employeeRepository);
                                                employeeId = employeeController
                                                                .getEmployeeById(findEmployeeid);

                                                if (employeeId == null) {
                                                        System.out.print("\n*****HERROR! ");
                                                        System.out.println("El id ingresado no existe");
                                                        condition2 = true;
                                                }
                                        } catch (Exception e) {
                                                System.out.print("\n*****HERROR! ");
                                                System.out.println("Herror al ingresar un id válido");
                                                input.nextLine();
                                                condition2 = true;
                                        }
                                } while (condition2);

                                LocalDate orderDate = null;
                                LocalDate requirDate = null;
                                LocalDate shippedDate = null;
                                boolean condition3;
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresa la fecha de la Orden de compra (orden del formato: 31/12/1999)");
                                                orderDate = LocalDate.parse(input.nextLine(),
                                                                formatter);
                                                System.out.println("Ingresar la fecha requerida");
                                                requirDate = LocalDate.parse(input.nextLine(),
                                                                formatter);
                                                System.out.println("Ingresar la fecha de envío");
                                                shippedDate = LocalDate.parse(input.nextLine(),
                                                                formatter);
                                                condition3 = false;
                                        } catch (Exception e) {

                                                System.out.println("Formato de fecha incorrecta ");
                                                condition3 = true;
                                        }
                                } while (condition3);

                                boolean condition4;
                                Shipper shipId = null;
                                Integer shipViaId;
                                do {
                                        try {
                                                System.out.println("Ingresar el id de la compañía de Shipper");
                                                shipViaId = input.nextInt();
                                                input.nextLine();
                                                condition4 = false;
                                                // Buscando Objeto shipper por su id
                                                ShipperRepository shipperRepository = new ShipperRepository();
                                                ShipperController shipperController = new ShipperController(
                                                                shipperRepository);
                                                shipId = shipperController.getShipperById(shipViaId);

                                                if (shipId == null) {
                                                        System.out.print("\n*****HERROR! ");
                                                        System.out.println("el id ingresado no existe");
                                                        condition4 = true;
                                                }

                                        } catch (Exception e) {
                                                System.out.print("\n*****HERROR! ");
                                                System.out.println("debe ingresar un id válido");
                                                input.nextLine();
                                                condition4 = true;
                                        }

                                } while (condition4);

                                boolean condition5;
                                double freight = 0.0;
                                do {

                                        try {
                                                System.out.println("Ingresar la carga");
                                                freight = input.nextDouble();
                                                input.nextLine();
                                                condition5 = false;
                                        } catch (Exception e) {
                                                System.out.print("\n*****HERROR");
                                                System.out.println("Valor de la carga incorrecto");
                                                condition5 = true;
                                                input.nextLine();
                                        }
                                } while (condition5);

                                String shipName;
                                do {
                                        System.out.println("Enter the ship Name");
                                        shipName = input.nextLine();
                                } while (!validate.validationsStrings(shipName));

                                String shipAddress;
                                do {
                                        System.out.println("Enter the ship address");
                                        shipAddress = input.nextLine();
                                } while (!validate.addressValidations(shipAddress));

                                String shipCity;
                                do {
                                        System.out.println("Enter the ship City");
                                        shipCity = input.nextLine();
                                } while (!validate.validationsStrings(shipCity));

                                String shipRegion;
                                do {
                                        System.out.println("Enter the ship Region");
                                        shipRegion = input.nextLine();
                                } while (!validate.validationsStrings(shipRegion));

                                String shipPostalCode;
                                do {
                                        System.out.println("Enter the ship postal code");
                                        shipPostalCode = input.nextLine();
                                } while (!validate.postalCodeValidations(shipPostalCode));

                                String shipCountry;
                                do {
                                        System.out.println("Enter the ship country");
                                        shipCountry = input.nextLine();
                                } while (!validate.validationsStrings(shipCountry));

                                order = new Order.Builder()

                                                .customersID(customerId)
                                                .employeeID(employeeId)
                                                .orderDate(orderDate)
                                                .requiredDate(requirDate)
                                                .shippedDate(shippedDate)
                                                .shipVia(shipId)
                                                .freight(freight)
                                                .shipName(shipName)
                                                .shipAddress(shipAddress)
                                                .shipCity(shipCity)
                                                .shipRegion(shipRegion)
                                                .shipPostalCode(shipPostalCode)
                                                .shipCountry(shipCountry)
                                                .build();
                                new OrderController(new OrderRepository()).addOrder(order);
                                break;
                        }
                        case SUPPLIER: {
                                String companyName;
                                do {
                                        System.out.println("Ingresar Nombre del proveedor");
                                        companyName = input.nextLine();
                                } while (!validate.validationsStrings(companyName));

                                String contactName;
                                do {
                                        System.out.println("Ingresar nombre de contacto");
                                        contactName = input.nextLine();
                                } while (!validate.validationsStrings(contactName));

                                String contacTilte;
                                do {
                                        System.out.println("Ingresar titulo de contacto");
                                        contacTilte = input.nextLine();
                                } while (!validate.validationsStrings(contacTilte));

                                String address;
                                do {
                                        System.out.println("Ingresar dirección");
                                        address = input.nextLine();
                                } while (!validate.addressValidations(address));

                                String city;
                                do {
                                        System.out.println("Ingresar ciudad");
                                        city = input.nextLine();
                                } while (!validate.validationsStrings(city));

                                String region;
                                do {
                                        System.out.println("Ingresar region");
                                        region = input.nextLine();
                                } while (!validate.validationsStrings(region));

                                String postaCode;
                                do {
                                        System.out.println("Ingresar codigo postal");
                                        postaCode = input.nextLine();
                                } while (!validate.postalCodeValidations(postaCode));

                                String country;
                                do {
                                        System.out.println("Ingresar país");
                                        country = input.nextLine();
                                } while (!validate.validationsStrings(country));

                                String phone;
                                do {
                                        System.out.println("Ingresar número de telefono");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                String fax;
                                do {
                                        System.out.println("Ingresar fax");
                                        fax = input.nextLine();
                                } while (!validate.numberPhoneValidations(fax));

                                String homePage;
                                do {
                                        System.out.println("Ingresar página web");
                                        homePage = input.nextLine();
                                } while (!validate.validationsStrings(homePage));

                                mySupplier = new Suppliers.Builder()

                                                .companyName(companyName)
                                                .contactName(contactName)
                                                .contactTitle(contacTilte)
                                                .address(address)
                                                .city(city)
                                                .region(region)
                                                .postalCode(postaCode)
                                                .country(country)
                                                .phone(phone)
                                                .fax(fax)
                                                .homePage(homePage)
                                                .build();
                                new SupplierController(new SupplierRepository())
                                                .addSupplier(mySupplier);
                                new SupplierController(new SupplierRepository()).addSupplier(mySupplier);
                                break;
                        }
                        case CATEGORIE: {
                                String categorieName;
                                do {
                                        System.out.println("Ingresar Nombre de la categoría");
                                        categorieName = input.nextLine();
                                } while (!validate.validationsStrings(categorieName));

                                String description;
                                do {
                                        System.out.println("Ingrear descripción");
                                        description = input.nextLine();

                                } while (!validate.validationsStrings(description));

                                categorie = new Categorie.Builder()

                                                .categoryName(categorieName)
                                                .description(description)
                                                .build();
                                new CategorieController(new CategorieRepository())
                                                .addCategorie(categorie);
                                break;
                        }
                        case PRODUCT: {
                                String productieName;
                                do {
                                        System.out.println("Ingresar Nombre del producto");
                                        productieName = input.nextLine();

                                } while (!validate.validationsStrings(productieName));

                                boolean condition;
                                int findSupplierId;
                                Suppliers supplierId = null;
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingrearel id del proveedor del producto (Supplier)");

                                                findSupplierId = input.nextInt();
                                                input.nextLine();
                                                condition = false;
                                                supplierId = new SupplierController(
                                                                new SupplierRepository())
                                                                .getSupplierById(findSupplierId);
                                                if (supplierId == null) {
                                                        System.out.print("\n*****HERROR! ");
                                                        System.out.println("El id del proveedor no existe");
                                                        condition = true;
                                                }
                                        } catch (Exception e) {
                                                System.out.print("\n*****HERROR! ");
                                                System.out.println("debe ingresar un id válido");
                                                condition = true;
                                                input.nextLine();
                                        }
                                } while (condition);

                                // Buscando supplier
                                boolean condition2;
                                int findCategorieId;
                                Categorie categorieId = null;
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresar el id de de la categoría que pertenece este producto");

                                                findCategorieId = input.nextInt();
                                                input.nextLine();
                                                condition2 = false;
                                                // Buscando categorie
                                                categorieId = new CategorieController(
                                                                new CategorieRepository())
                                                                .getCategorieById(findCategorieId);
                                                if (categorieId == null) {
                                                        System.out.println("El id de la categoría no existe");
                                                        condition2 = true;
                                                }

                                        } catch (Exception e) {
                                                System.out.println("\n*****HERROR! ");
                                                System.out.println("Error al introducir el id ");
                                                condition2 = true;
                                                input.nextLine();
                                        }
                                } while (condition2);

                                String quantity;
                                do {
                                        System.out.println("Ingresar la cantidad por unidad");
                                        quantity = input.nextLine();

                                } while (!validate.quantityValidation(quantity));

                                double unitPrice = 0.0;
                                boolean condition3;
                                do {
                                        try {
                                                System.out.println("Ingresar el precio unitario");
                                                unitPrice = input.nextDouble();
                                                input.nextLine();

                                                if (unitPrice <= 0) {
                                                        System.out.print("\nHERROR! ");
                                                        System.out.println("El precio debe ser mayor que cero");
                                                        condition3 = true;
                                                } else {
                                                        condition3 = false;
                                                }

                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("Debe ingresar un valor válido");
                                                condition3 = true;
                                                input.nextLine();
                                        }
                                } while (condition3);

                                int unitsInStock = 0;
                                boolean condition4;
                                do {
                                        try {
                                                System.out.println("Ingresar unidades en Stock");
                                                unitsInStock = input.nextInt();
                                                input.nextLine();
                                                condition4 = false;

                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition4 = true;
                                                input.nextLine();
                                        }

                                } while (condition4);

                                int unitsOnOrder = 0;
                                boolean condition5;
                                do {
                                        try {
                                                System.out.println("Ingresar unidades ordenadas");
                                                unitsOnOrder = input.nextInt();
                                                input.nextLine();
                                                condition5 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition5 = true;
                                                input.nextLine();
                                        }
                                } while (condition5);

                                int reorderLevel = 0;
                                boolean condition6;
                                do {
                                        try {
                                                System.out.println("Ingresar nivel de orden");
                                                reorderLevel = input.nextInt();
                                                input.nextLine();
                                                condition6 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition6 = true;
                                                input.nextLine();
                                        }
                                } while (condition6);

                                boolean discontinued = false; // valor por defecto
                                boolean condition7;
                                do {
                                        try {
                                                System.out.println("Descontinuado. escribir (true/false)");
                                                discontinued = input.nextBoolean();
                                                condition7 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition7 = true;
                                        }
                                } while (condition7);

                                product = new Product.Builder()

                                                .productName(productieName)
                                                .supplierID(supplierId)
                                                .categoryID(categorieId)

                                                .quantityPerUnit(quantity)
                                                .unitPrice(unitPrice)
                                                .unitsInStock(unitsInStock)
                                                .unitsOnOrder(unitsOnOrder)
                                                .reorderLevel(reorderLevel)
                                                .discontinued(discontinued)
                                                .build();
                                new ProductController(new ProductRepository())
                                                .addProduct(product);
                                break;
                        }
                        case ORDER_DETAILS: {

                                int findOrderId;
                                boolean condition;
                                Order orderid = null;
                                do {
                                        try {// Buscando e id de la orden
                                                System.out.println("Ingresar el id de la Orden");
                                                findOrderId = input.nextInt();
                                                input.nextLine();
                                                condition = false;
                                                orderid = new OrderController(new OrderRepository())
                                                                .getOrderById(findOrderId);

                                                if (orderid == null) {
                                                        System.out.println("el id de la Orden no existe ");
                                                        condition = true;
                                                }
                                        } catch (Exception e) {

                                                System.out.print("\n****HERROR! ");
                                                System.out.println("Error al introducirr el id");
                                                condition = true;
                                                input.nextLine();
                                        }

                                } while (condition);

                                int findProductId;
                                boolean condition2;
                                Product productId = null;
                                do {

                                        try {
                                                System.out.println("Ingresar el id del producto");
                                                findProductId = input.nextInt();
                                                input.nextLine();
                                                condition2 = false;
                                                productId = new ProductController(
                                                                new ProductRepository())
                                                                .getProductById(findProductId);
                                                if (productId == null) {
                                                        System.out.println("El id del producto no existe");
                                                        condition2 = true;
                                                }

                                        } catch (Exception e) {

                                                System.out.println("Error al introducir id ");
                                                condition2 = true;
                                                input.nextLine();
                                        }

                                } while (condition2);

                                int unitPrice = 0;
                                boolean condition3;
                                do {

                                        try {
                                                System.out.println("Ingresar precio Unitario");
                                                unitPrice = input.nextInt();
                                                input.nextLine();
                                                condition3 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition3 = true;
                                                input.nextLine();
                                        }
                                } while (condition3);

                                int quantity = 0;
                                boolean condition4;
                                do {
                                        try {
                                                System.out.println("Ingresar cantidad");
                                                quantity = input.nextInt();
                                                input.nextLine();
                                                condition4 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition4 = true;
                                                input.nextLine();
                                        }
                                } while (condition4);

                                double discount = 0.0;
                                boolean condition5;
                                do {
                                        try {
                                                System.out.println("Ingresar descuento");
                                                discount = input.nextDouble();
                                                input.nextLine();
                                                condition5 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition5 = true;
                                                input.nextLine();
                                        }
                                } while (condition5);

                                orderDetails = new OrderDetails.Builder()

                                                .orderID(orderid)
                                                .productID(productId)
                                                .unitPrice(unitPrice)
                                                .quantity(quantity)
                                                .discount(discount)
                                                .build();
                                new OrderDetailsController(new OrderDetailsRepository())
                                                .addOrderDetails(orderDetails);
                                break;
                        }

                        default:
                                break;
                }
        }
}
