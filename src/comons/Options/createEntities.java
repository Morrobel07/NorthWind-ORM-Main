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

        public void crear() {
                switch (this) {
                        case CUSTOMER: {

                                System.out.println("Ingresa el nombre de la comopañía");
                                String companyName = input.nextLine();
                                // validando
                                if (!validate.validationsStrings(companyName)) {
                                        break;
                                }
                                System.out.println("Ingresa el nombre de contacto");
                                String contactName = input.nextLine();
                                if (!validate.validationsStrings(contactName)) {
                                        break;
                                }
                                System.out.println("Ingresa el titulo del contacto");
                                String contactTitle = input.nextLine();
                                if (!validate.validationsStrings(contactTitle)) {
                                        break;
                                }
                                System.out.println("Ingresa la ciudad");
                                String city = input.nextLine();
                                if (!validate.validationsStrings(companyName)) {
                                        break;
                                }
                                System.out.println("Ingresa la region");
                                String region = input.nextLine();
                                if (!validate.validationsStrings(region)) {
                                        break;
                                }
                                System.out.println("Ingresa el país");
                                String country = input.nextLine();
                                if (!validate.validationsStrings(country)) {
                                        break;
                                }
                                System.out.println("Ingresa la dirección");
                                String address = input.nextLine();
                                if (!validate.addressValidations(address)) {
                                        break;
                                }

                                System.out.println("Ingresa codigo postal");
                                String postalCode = input.nextLine();
                                if (!validate.postalCodeValidations(postalCode)) {
                                        break;
                                }
                                System.out.println("Ingresa el número de teléfono");
                                String phone = input.nextLine();
                                if (!validate.numberPhoneValidations(phone)) {
                                        break;
                                }
                                System.out.println("Ingresa el fax");
                                String fax = input.nextLine();
                                if (!validate.numberPhoneValidations(fax)) {
                                        break;
                                }

                                 Customer customer =  Customer.builder()

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

                                System.out.println("Ingresa el apellido");
                                String lastName = input.nextLine();
                                if (!validate.validationsStrings(lastName)) {
                                        break;
                                }
                                System.out.println("Ingresar Nombre");
                                String name = input.nextLine();
                                if (!validate.validationsStrings(name)) {
                                        break;
                                }
                                System.out.println("Ingresa el titulo");
                                String title = input.nextLine();
                                if (!validate.validationsStrings(title)) {
                                        break;
                                }
                                System.out.println("Ingresa el title Of courtesy");
                                String titleOfcourtesy = input.nextLine();
                                if (!validate.validationsStrings(titleOfcourtesy)) {
                                        break;
                                }
                                System.out.println(
                                                "Ingresar su fecha de cumpleaños (orden del formato: 31/12/1999)");
                                LocalDate birtDate;
                                LocalDate hireDate;
                                try {
                                        birtDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                        System.out.println("Ingresa fecha de contrato");
                                        hireDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                } catch (Exception e) {

                                        System.out.println("Formato de fecha incorrecta");
                                        break;
                                }

                                System.out.println("Ingresar su dirección");
                                String address = input.nextLine();
                                if (!validate.addressValidations(address)) {
                                        break;
                                }
                                System.out.println("Ingresar la ciudad");
                                String city = input.nextLine();
                                if (!validate.validationsStrings(city)) {
                                        break;
                                }
                                System.out.println("Ingrear la region");
                                String region = input.nextLine();
                                if (!validate.validationsStrings(region)) {
                                        break;
                                }
                                System.out.println("ingresar el código postal");
                                String postalCode = input.nextLine();
                                if (!validate.postalCodeValidations(postalCode)) {
                                        break;
                                }
                                System.out.println("Ingresar país");
                                String country = input.nextLine();
                                if (!validate.validationsStrings(country)) {
                                        break;
                                }
                                System.out.println("Ingresar número de telefono");
                                String phone = input.nextLine();
                                if (!validate.numberPhoneValidations(phone)) {
                                        break;
                                }
                                System.out.println("Ingresar la extension");
                                String extension = input.nextLine();
                                if (!validate.extensionNumber(extension)) {
                                        break;
                                }
                                // foto
                                System.out.println("Ingresar Nota");
                                String note = input.nextLine();
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

                                System.out.println("Ingresar nombre del Shipper");
                                String companyName = input.nextLine();
                                if (!validate.validationsStrings(companyName)) {
                                        break;
                                }
                                System.out.println("Ingresar el número de teléfono");
                                String phone = input.nextLine();
                                if (!validate.numberPhoneValidations(phone)) {
                                        break;
                                }
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

                                System.out.println(
                                                "Ingresar el id del customer a quien pertenece esta orden");
                                int findCustomerId;
                                try {
                                        findCustomerId = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("Herror al ingresar un id válido");
                                        break;
                                }

                                // buscando el objeto Customer que tenga el mismo id que ingresó
                                // el usuario
                                CustomerRepository customerRepository = new CustomerRepository();
                                CustomerController customerController = new CustomerController(
                                                customerRepository);
                                Customer customerId = customerController
                                                .getCustomerById(findCustomerId);
                                if (customerId == null) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("El id igresado no existe");
                                        break;
                                }
                                System.out.println(
                                                "Ingresar el id del empleado quien realiza la Orden de compra");
                                int findEmployeeid;
                                try {
                                        findEmployeeid = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("Herror al ingresar un id válido");
                                        break;
                                }

                                // Buscando el objeto Employee por su id
                                EmployeeRepository employeeRepository = new EmployeeRepository();
                                EmployeeController employeeController = new EmployeeController(
                                                employeeRepository);
                                Employee employeeId = employeeController
                                                .getEmployeeById(findEmployeeid);

                                if (employeeId == null) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("El id ingresado no existe");
                                        break;
                                }
                                System.out.println(
                                                "Ingresa la fecha de la Orden de compra (orden del formato: 31/12/1999)");
                                LocalDate orderDate;
                                LocalDate requirDate;
                                LocalDate shippedDate;
                                try {
                                        orderDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                        System.out.println("Ingresar la fecha requerida");
                                        requirDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                        System.out.println("Ingresar la fecha de envío");
                                        shippedDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                } catch (Exception e) {

                                        System.out.println("Formato de fecha incorrecta ");
                                        break;
                                }

                                System.out.println("Ingresar el id de la compañía de Shipper");
                                Integer shipViaId;
                                try {
                                        shipViaId = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("debe ingresar un id válido");
                                        break;
                                }

                                // Buscando Objeto shipper por su id
                                ShipperRepository shipperRepository = new ShipperRepository();
                                ShipperController shipperController = new ShipperController(
                                                shipperRepository);
                                Shipper shipId = shipperController.getShipperById(shipViaId);

                                if (shipId == null) {
                                        System.out.println("el id ingresado no existe");
                                        break;
                                }

                                System.out.println("Ingresar la carga");
                                double freight;
                                try {
                                        freight = input.nextDouble();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\n*****HERROR");
                                        System.out.println("Valor de la carga incorrecto");
                                        break;
                                }

                                System.out.println("Enter the ship Name");
                                String shipName = input.nextLine();
                                if (!validate.validationsStrings(shipName)) {
                                        break;
                                }
                                System.out.println("Enter the ship address");
                                String shipAddress = input.nextLine();
                                if (!validate.addressValidations(shipAddress)) {
                                        break;
                                }
                                System.out.println("Enter the ship City");
                                String shipCity = input.nextLine();
                                if (!validate.validationsStrings(shipCity)) {
                                        break;
                                }
                                System.out.println("Enter the ship Region");
                                String shipRegion = input.nextLine();
                                if (!validate.validationsStrings(shipRegion)) {
                                        break;
                                }
                                System.out.println("Enter the ship postal code");
                                String shipPostalCode = input.nextLine();
                                if (!validate.postalCodeValidations(shipPostalCode)) {
                                        break;
                                }
                                System.out.println("Enter the ship country");
                                String shipCountry = input.nextLine();
                                if (!validate.validationsStrings(shipCountry)) {
                                        break;
                                }

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

                                System.out.println("Ingresar Nombre del proveedor");
                                String companyName = input.nextLine();
                                if (!validate.validationsStrings(companyName)) {
                                        break;
                                }
                                System.out.println("Ingresar nombre de contacto");
                                String contactName = input.nextLine();
                                if (!validate.validationsStrings(contactName)) {
                                        break;
                                }
                                System.out.println("Ingresar titulo de contacto");
                                String contacTilte = input.nextLine();
                                if (!validate.validationsStrings(contacTilte)) {
                                        break;
                                }
                                System.out.println("Ingresar dirección");
                                String address = input.nextLine();
                                if (!validate.addressValidations(address)) {
                                        break;
                                }
                                System.out.println("Ingresar ciudad");
                                String city = input.nextLine();
                                if (!validate.validationsStrings(city)) {
                                        break;
                                }
                                System.out.println("Ingresar region");
                                String region = input.nextLine();
                                if (!validate.validationsStrings(region)) {
                                        break;
                                }
                                System.out.println("Ingresar codigo postal");
                                String postaCode = input.nextLine();
                                if (!validate.postalCodeValidations(postaCode)) {
                                        break;
                                }
                                System.out.println("Ingresar país");
                                String country = input.nextLine();
                                if (!validate.validationsStrings(country)) {
                                        break;
                                }
                                System.out.println("Ingresar número de telefono");
                                String phone = input.nextLine();
                                if (!validate.numberPhoneValidations(phone)) {
                                        break;
                                }
                                System.out.println("Ingresar fax");
                                String fax = input.nextLine();
                                if (!validate.numberPhoneValidations(fax)) {
                                        break;
                                }
                                System.out.println("Ingresar página web");
                                String homePage = input.nextLine();
                                if (!validate.validationsStrings(homePage)) {
                                        break;
                                }
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
                                break;
                        }
                        case CATEGORIE: {

                                System.out.println("Ingresar Nombre de la categoría");
                                String categorieName = input.nextLine();
                                if (!validate.validationsStrings(categorieName)) {
                                        break;
                                }
                                System.out.println("Ingrear descripción");
                                String description = input.nextLine();
                                if (!validate.validationsStrings(description)) {
                                        break;
                                }
                                categorie = new Categorie.Builder()

                                                .categoryName(categorieName)
                                                .description(description)
                                                .build();
                                new CategorieController(new CategorieRepository())
                                                .addCategorie(categorie);
                                break;
                        }
                        case PRODUCT: {

                                System.out.println("Ingresar Nombre del producto");
                                String productieName = input.nextLine();
                                if (!validate.validationsStrings(productieName)) {
                                        break;
                                }
                                System.out.println(
                                                "Ingrearel id del proveedor del producto (Supplier)");
                                int findSupplierId;
                                // validando id
                                try {
                                        findSupplierId = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("debe ingresar un id válido");
                                        break;
                                }
                                // Buscando supplier
                                Suppliers supplierId = new SupplierController(
                                                new SupplierRepository())
                                                .getSupplierById(findSupplierId);
                                if (supplierId == null) {
                                        System.out.print("\n*****HERROR! ");
                                        System.out.println("El id del proveedor no existe");
                                        break;
                                }
                                System.out.println(
                                                "Ingresar el id de de la categoría que pertenece este producto");
                                int findCategorieId;
                                try {
                                        findCategorieId = input.nextInt();
                                        input.nextLine();

                                } catch (Exception e) {
                                        System.out.println("\n*****HERROR! ");
                                        System.out.println("Error al introducir el id ");
                                        break;
                                }

                                // Buscando categorie
                                Categorie categorieId = new CategorieController(
                                                new CategorieRepository())
                                                .getCategorieById(findCategorieId);
                                if (categorieId == null) {
                                        System.out.println("El id de la categoría no existe");
                                        return;
                                }
                                System.out.println("Ingresar la cantidad por unidad");
                                String quantity = input.nextLine();

                                System.out.println("Ingresar el precio unitario");
                                double unitPrice;
                                try {
                                        unitPrice = input.nextDouble();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }

                                System.out.println("Ingresar unidades en Stock");
                                int unitsInStock;
                                try {
                                        unitsInStock = input.nextInt();
                                        input.nextLine();

                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
                                System.out.println("Ingresar unidades ordenadas");
                                int unitsOnOrder;
                                try {
                                        unitsOnOrder = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
                                System.out.println("Ingresar nivel de orden");
                                int reorderLevel;
                                try {
                                        reorderLevel = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
                                System.out.println("Descontinuado. escribir (true/false)");
                                boolean discontinued = false; // valor por defecto
                                try {
                                        discontinued = input.nextBoolean();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }

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
                                System.out.println("Ingresar el id de la Orden");
                                int findOrderId;

                                try {
                                        findOrderId = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducirr el id ");
                                        break;
                                }
                                // Buscando e id de la orden
                                Order orderid = new OrderController(new OrderRepository())
                                                .getOrderById(findOrderId);

                                if (orderid == null) {
                                        System.out.println("el id de la Orden no existe ");
                                        break;
                                }

                                System.out.println("Ingresarl el id del producto");
                                int findProductId;
                                try {
                                        findProductId = input.nextInt();
                                        input.nextLine();

                                } catch (Exception e) {

                                        System.out.println("Error al introducir id ");
                                        break;
                                }
                                Product productId = new ProductController(
                                                new ProductRepository())
                                                .getProductById(findProductId);
                                if (productId == null) {
                                        System.out.println("El id del producto no existe");
                                        break;
                                }
                                System.out.println("Ingresar precio Unitario");
                                int unitPrice;
                                try {
                                        unitPrice = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
                                System.out.println("Ingresar cantidad");
                                int quantity;
                                try {
                                        quantity = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
                                System.out.println("Ingresar descuento");
                                double discount;
                                try {
                                        discount = input.nextDouble();
                                        input.nextLine();

                                } catch (Exception e) {
                                        System.out.print("\nHERROR! ");
                                        System.out.println("debe ingresar un valor válido");
                                        break;
                                }
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
