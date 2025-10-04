package comons.Options;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import comons.Validations;
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

        public void create() {// CREANDO ENTIDADES Y VALIDANDO CADA UNA DE ELLAS
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
                                        System.out.println(
                                                        "Ingresar el número de teléfono (formato válido: (809)(829)(849) puede ser todo junto o separado por guion)");
                                        System.out.println("Ejemplo: 8093808521 o 809-380-8521");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                String fax;
                                do {
                                        System.out.println("Ingresa el fax");
                                        fax = input.nextLine();
                                } while (!validate.numberPhoneValidations(fax));

                                Customer customer = Customer.builder()
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
                                        System.out.println(
                                                        "Ingresar el número de teléfono (formato válido: (809)(829)(849) puede ser todo junto o separado por guion)");
                                        System.out.println("Ejemplo: 8093808521 o 809-380-8521");
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

                                Employee employee = Employee.builder()

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
                                        System.out.println(
                                                        "Ingresar el número de teléfono (formato válido: (809)(829)(849) puede ser todo junto o separado por guion)");
                                        System.out.println("Ejemplo: 8093808521 o 809-380-8521");
                                        phone = input.nextLine();
                                } while (!validate.numberPhoneValidations(phone));

                                Shipper shipper = Shipper.builder()

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
                                System.out.println("*****Mostrando customer");
                                System.out.println(new CustomerController(new CustomerRepository()).getAllCustomers()
                                                + "\n");
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresar el id del customer a quien pertenece esta orden");
                                                findCustomerId = Integer.parseInt(input.nextLine());
                                                // input.nextLine();
                                                condition1 = false;
                                                // buscando el objeto Customer que tenga el mismo id que ingresó
                                                // el usuario
                                                CustomerRepository customerRepository = new CustomerRepository();
                                                CustomerController customerController = new CustomerController(
                                                                customerRepository);
                                                customerId = customerController
                                                                .getCustomerById(findCustomerId);

                                                if (customerId == null) {
                                                        System.out.print("\n*****ERROR! ");
                                                        System.out.println("El id igresado no existe");
                                                        condition1 = true;
                                                }

                                        } catch (Exception e) {

                                                System.out.print("\n*****ERROR! ");
                                                System.out.println("Herror al ingresar un id válido");
                                                condition1 = true;

                                        }
                                } while (condition1);

                                boolean condition2;
                                int findEmployeeid;
                                Employee employeeId = null;
                                System.out.println("*****Mostrando Empleados");
                                System.out.println(new EmployeeController(new EmployeeRepository()).getAllEmployees()
                                                + "\n");
                                do {

                                        try {
                                                System.out.println(
                                                                "Ingresar el id del empleado quien realiza la Orden de compra");

                                                findEmployeeid = Integer.parseInt(input.nextLine());

                                                condition2 = false;
                                                // Buscando el objeto Employee por su id
                                                EmployeeRepository employeeRepository = new EmployeeRepository();
                                                EmployeeController employeeController = new EmployeeController(
                                                                employeeRepository);
                                                employeeId = employeeController
                                                                .getEmployeeById(findEmployeeid);

                                                if (employeeId == null) {
                                                        System.out.print("\n*****ERROR! ");
                                                        System.out.println("El id ingresado no existe");
                                                        condition2 = true;
                                                }
                                        } catch (Exception e) {
                                                System.out.print("\n*****ERROR! ");
                                                System.out.println("Herror al ingresar un id válido");

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
                                System.out.println("*****Mostrando Shippers");
                                System.out.println(
                                                new ShipperController(new ShipperRepository()).getAllShippers() + "\n");
                                do {
                                        try {
                                                System.out.println("Ingresar el id de la compañía de Shipper");
                                                shipViaId = Integer.parseInt(input.nextLine());

                                                condition4 = false;
                                                // Buscando Objeto shipper por su id
                                                ShipperRepository shipperRepository = new ShipperRepository();
                                                ShipperController shipperController = new ShipperController(
                                                                shipperRepository);
                                                shipId = shipperController.getShipperById(shipViaId);

                                                if (shipId == null) {
                                                        System.out.print("\n*****ERROR! ");
                                                        System.out.println("el id ingresado no existe");
                                                        condition4 = true;
                                                }

                                        } catch (Exception e) {
                                                System.out.print("\n*****ERROR! ");
                                                System.out.println("debe ingresar un id válido");

                                                condition4 = true;
                                        }

                                } while (condition4);

                                boolean condition5;
                                double freight = 0.0;
                                do {

                                        try {
                                                System.out.println("Ingresar la carga");
                                                freight = Double.parseDouble(input.nextLine());

                                                condition5 = false;
                                        } catch (Exception e) {
                                                System.out.print("\n*****ERROR");
                                                System.out.println("Valor de la carga incorrecto");
                                                condition5 = true;

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

                                Order order = Order.builder()

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
                                        System.out.println(
                                                        "Ingresar el número de teléfono (formato válido: (809)(829)(849) puede ser todo junto o separado por guion)");
                                        System.out.println("Ejemplo: 8093808521 o 809-380-8521");
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

                                Suppliers supplier = Suppliers.builder()

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

                                new SupplierController(new SupplierRepository()).addSupplier(supplier);
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

                                Categorie categorie = Categorie.builder()

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
                                System.out.println("*****Mostrando suplidores");
                                System.out.println(new SupplierController(new SupplierRepository()).getAllSuppliers()
                                                + "\n");
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingrearel id del proveedor del producto (Supplier)");

                                                findSupplierId = Integer.parseInt(input.nextLine());

                                                condition = false;
                                                supplierId = new SupplierController(
                                                                new SupplierRepository())
                                                                .getSupplierById(findSupplierId);
                                                if (supplierId == null) {
                                                        System.out.print("\n*****ERROR! ");
                                                        System.out.println("El id del proveedor no existe");
                                                        condition = true;
                                                }
                                        } catch (Exception e) {
                                                System.out.print("\n*****ERROR! ");
                                                System.out.println("debe ingresar un id válido");
                                                condition = true;

                                        }
                                } while (condition);

                                boolean condition2;
                                int findCategorieId;
                                Categorie categorieId = null;
                                System.out.println("*****Mostrando lista de categorias");
                                System.out.println(new CategorieController(new CategorieRepository()).getAllCategories()
                                                + "\n");
                                do {
                                        try {
                                                System.out.println(
                                                                "Ingresar el id de de la categoría que pertenece este producto");

                                                findCategorieId = Integer.parseInt(input.nextLine());

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
                                                System.out.println("\n*****ERROR! ");
                                                System.out.println("Error al introducir el id ");
                                                condition2 = true;

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
                                                unitPrice = Double.parseDouble(input.nextLine());

                                                if (unitPrice <= 0) {
                                                        System.out.print("\nERROR! ");
                                                        System.out.println("El precio debe ser mayor que cero");
                                                        condition3 = true;
                                                } else {
                                                        condition3 = false;
                                                }

                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("Debe ingresar un valor válido");
                                                condition3 = true;

                                        }
                                } while (condition3);

                                int unitsInStock = 0;
                                boolean condition4;
                                do {
                                        try {
                                                System.out.println("Ingresar unidades en Stock");
                                                unitsInStock = Integer.parseInt(input.nextLine());

                                                condition4 = false;

                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition4 = true;

                                        }

                                } while (condition4);

                                int unitsOnOrder = 0;
                                boolean condition5;
                                do {
                                        try {
                                                System.out.println("Ingresar unidades ordenadas");
                                                unitsOnOrder = Integer.parseInt(input.nextLine());

                                                condition5 = false;

                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition5 = true;

                                        }
                                } while (condition5);

                                int reorderLevel = 0;
                                boolean condition6;
                                do {
                                        try {
                                                System.out.println("Ingresar nivel de orden");
                                                reorderLevel = Integer.parseInt(input.nextLine());

                                                condition6 = false;

                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition6 = true;

                                        }
                                } while (condition6);

                                boolean discontinued = false; // valor por defecto
                                boolean condition7;
                                do {
                                        try {
                                                System.out.println("Producto Descontinuado. escribir (true/false)");
                                                discontinued = input.nextBoolean();
                                                condition7 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nHERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition7 = true;
                                        }
                                } while (condition7);

                                Product product = Product.builder()

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
                                System.out.println("*****Mostrando Ordenes ");
                                System.out.println(new OrderController(new OrderRepository()).getAllOrders() + "\n");
                                do {
                                        try {// Buscando e id de la orden
                                                System.out.println("Ingresar el id de la Orden");
                                                findOrderId = Integer.parseInt(input.nextLine());

                                                condition = false;
                                                orderid = new OrderController(new OrderRepository())
                                                                .getOrderById(findOrderId);

                                                if (orderid == null) {
                                                        System.out.println("el id de la Orden no existe ");
                                                        condition = true;
                                                }
                                        } catch (Exception e) {

                                                System.out.print("\n****ERROR! ");
                                                System.out.println("Error al introducirr el id");
                                                condition = true;

                                        }

                                } while (condition);

                                int findProductId;
                                boolean condition2;
                                Product productId = null;
                                System.out.println("*****Mostrando Lista de Productos");
                                System.out.println(new ProductController(new ProductRepository()).getAllProducts());
                                do {

                                        try {
                                                System.out.println("Ingresar el id del producto");
                                                findProductId = Integer.parseInt(input.nextLine());

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

                                        }

                                } while (condition2);

                                int unitPrice = 0;
                                boolean condition3;
                                do {

                                        try {
                                                System.out.println("Ingresar precio Unitario");
                                                unitPrice = Integer.parseInt(input.nextLine());

                                                condition3 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition3 = true;

                                        }
                                } while (condition3);

                                int quantity = 0;
                                boolean condition4;
                                do {
                                        try {
                                                System.out.println("Ingresar cantidad");
                                                quantity = Integer.parseInt(input.nextLine());

                                                condition4 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition4 = true;

                                        }
                                } while (condition4);

                                double discount = 0.0;
                                boolean condition5;
                                do {
                                        try {
                                                System.out.println("Ingresar descuento");
                                                discount = Double.parseDouble(input.nextLine());

                                                condition5 = false;
                                        } catch (Exception e) {
                                                System.out.print("\nERROR! ");
                                                System.out.println("debe ingresar un valor válido");
                                                condition5 = true;

                                        }
                                } while (condition5);

                                OrderDetails orderDetails = OrderDetails.builder()

                                                .orderDetailsId(orderid)
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