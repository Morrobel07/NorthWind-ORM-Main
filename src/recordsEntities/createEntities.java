package recordsEntities;

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
import models.MySupplier;
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
        MySupplier mySupplier;
        Categorie categorie;
        Product product;
        OrderDetails orderDetails;

        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");

        public void crear() {
                switch (this) {
                        case CUSTOMER: {
                                System.out.println("Ingresa el id del customer");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }

                                System.out.println("Ingresa el nombre de la comopañía");
                                String companyName = input.nextLine();
                                System.out.println("Ingresa el nombre de contacto");
                                String contactName = input.nextLine();
                                System.out.println("Ingresa el titulo del contacto");
                                String contactTitle = input.nextLine();
                                System.out.println("Ingresa la dirección");
                                String address = input.nextLine();
                                System.out.println("Ingresa la ciudad");
                                String city = input.nextLine();
                                System.out.println("Ingresa la region");
                                String region = input.nextLine();
                                System.out.println("Ingresa codigo postal");
                                String postalCode = input.nextLine();
                                System.out.println("Ingresa el país");
                                String country = input.nextLine();
                                System.out.println("Ingresa el número de teléfono");
                                String phone = input.nextLine();
                                System.out.println("Ingresa el fax");
                                String fax = input.nextLine();

                                customer = new Customer.Builder()
                                                .customerID(id)
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
                                System.out.println(
                                                new CustomerController(new CustomerRepository())
                                                                .getAllCustomers());
                                break;
                        }
                        case EMPLOYEE: {
                                System.out.println("Ingrese el Id de Employee");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println("Ingresa el apellido");
                                String lastName = input.nextLine();
                                System.out.println("Ingresar Nombre");
                                String name = input.nextLine();
                                System.out.println("Ingresa el titulo");
                                String title = input.nextLine();
                                System.out.println("Ingresa el title Of courtesy");
                                String titleOfcourtesy = input.nextLine();
                                System.out.println(
                                                "Ingresar su fecha de cumpleaños (orden: día, mes y año)");
                                LocalDate birtDate;
                                LocalDate hireDate;
                                try {
                                        birtDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                        System.out.println("Ingresa fecha de contrato");
                                        hireDate = LocalDate.parse(input.nextLine(),
                                                        formatter);
                                } catch (Exception e) {

                                        System.out.println("Formato de fecha incorrecta" + e);
                                        return;
                                }

                                System.out.println("Ingresar su dirección");
                                String address = input.nextLine();
                                System.out.println("Ingresar la ciudad");
                                String city = input.nextLine();
                                System.out.println("Ingrear la region");
                                String region = input.nextLine();
                                System.out.println("ingresar el código postal");
                                String postalCode = input.nextLine();
                                System.out.println("Ingresar país");
                                String country = input.nextLine();
                                System.out.println("Ingresar número de telefono");
                                String phone = input.nextLine();
                                System.out.println("Ingresar la extension");
                                String extension = input.nextLine();
                                System.out.println("Ingresar su foto");
                                String photo = input.nextLine();
                                System.out.println("Ingresar Nota");
                                String note = input.nextLine();
                                employee = new Employee.Builder()
                                                .employeeID(id)
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
                                                .photo(photo)
                                                .notes(note)
                                                .region(region)
                                                .build();
                                new EmployeeController(new EmployeeRepository())
                                                .addEmployee(employee);
                                break;
                        }
                        case SHIPPER: {
                                System.out.println("Ingresar el id Shipper");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println("Ingresar nombre de la compañía");
                                String companyName = input.nextLine();
                                System.out.println("Ingresar el número de teléfono");
                                String phone = input.nextLine();
                                shipper = new Shipper.Builder()
                                                .shipperID(id)
                                                .companyName(companyName)
                                                .phone(phone)
                                                .build();
                                // agregando al backend
                                new ShipperController(new ShipperRepository())
                                                .addShipper(shipper);
                                break;
                        }
                        case ORDER: {
                                System.out.println("Ingrese el id de la orden");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println(
                                                "Ingresar el id del customer a quien pertenece esta orden");
                                int findCustomerId = input.nextInt();
                                input.nextLine();
                                // buscando el objeto Customer que tenga el mismo id que ingresó
                                // el usuario
                                CustomerRepository customerRepository = new CustomerRepository();
                                CustomerController customerController = new CustomerController(
                                                customerRepository);
                                Customer customerId = customerController
                                                .getCustomerById(findCustomerId);
                                if (customerId.getCustomerID() == null) {
                                        System.out.println("El id igresado no existe");
                                        return;
                                }
                                System.out.println(
                                                "Ingresar el id del empleado quien realiza la Orden de compra");
                                int findEmployeeid = input.nextInt();
                                input.nextLine();
                                // Buscando el objeto Employee por su id
                                EmployeeRepository employeeRepository = new EmployeeRepository();
                                EmployeeController employeeController = new EmployeeController(
                                                employeeRepository);
                                Employee employeeId = employeeController
                                                .getEmployeeById(findEmployeeid);

                                if (employeeId.getEmployeeID() == null) {
                                        System.out.println("El id ingresado no existe");
                                        return;
                                }
                                System.out.println(
                                                "Ingresa la fecha de la Orden de compra (día, mes y año)");
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

                                        System.out.println("Formato de fecha incorrecta " + e);
                                        return;
                                }

                                System.out.println("Ingresar el id de la compañía de envíos");
                                Integer shipViaId = input.nextInt();
                                input.nextLine();
                                // Buscando Objeto shipper por su id
                                ShipperRepository shipperRepository = new ShipperRepository();
                                ShipperController shipperController = new ShipperController(
                                                shipperRepository);
                                Shipper shipId = shipperController.getShipperById(shipViaId);

                                if (shipId.getShipperID() == null) {
                                        System.out.println("el id ingresado no existe");
                                        return;
                                }

                                System.out.println("Ingresar la carga");
                                double freight = input.nextDouble();
                                input.nextLine();
                                System.out.println("Enter the ship Name");
                                String shipName = input.nextLine();
                                System.out.println("Enter the ship address");
                                String shipAddress = input.nextLine();
                                System.out.println("Enter the ship City");
                                String shipCity = input.nextLine();
                                System.out.println("Enter the ship Region");
                                String shipRegion = input.nextLine();
                                System.out.println("Enter the ship postal code");
                                String shipPostalCode = input.nextLine();
                                System.out.println("Enter the ship country");
                                String shipCountry = input.nextLine();

                                order = new Order.Builder()
                                                .orderID(id)
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
                                System.out.println("Ingresar el id del Proveedor (Suppliers)");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println("Ingresar Nombre del proveedor");
                                String companyName = input.nextLine();
                                System.out.println("Ingresar nombre de contacto");
                                String contactName = input.nextLine();
                                System.out.println("Ingresar titulo de contacto");
                                String contacTilte = input.nextLine();
                                System.out.println("Ingresar dirección");
                                String address = input.nextLine();
                                System.out.println("Ingresar ciudad");
                                String city = input.nextLine();
                                System.out.println("Ingresar region");
                                String region = input.nextLine();
                                System.out.println("Ingresar codigo postal");
                                String postaCode = input.nextLine();
                                System.out.println("Ingresar país");
                                String country = input.nextLine();
                                System.out.println("Ingresar número de telefono");
                                String phone = input.nextLine();
                                System.out.println("Ingresar fax");
                                String fax = input.nextLine();
                                System.out.println("Ingresar página web");
                                String homePage = input.nextLine();

                                mySupplier = new MySupplier.Builder()
                                                .supplierID(id)
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
                                System.out.println("Ingresar id de la Categoria");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println("Ingresar Nombre de la categoría");
                                String categorieName = input.nextLine();
                                System.out.println("Ingrear descripción");
                                String description = input.nextLine();
                                categorie = new Categorie.Builder()
                                                .categoryID(id)
                                                .categoryName(categorieName)
                                                .description(description)
                                                .build();
                                new CategorieController(new CategorieRepository())
                                                .addCategorie(categorie);
                                break;
                        }
                        case PRODUCT: {
                                System.out.println("Ingresar id del Producto");
                                int id;
                                try {
                                        id = input.nextInt();
                                        input.nextLine();
                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }
                                System.out.println("Ingresar Nombre del producto");
                                String productieName = input.nextLine();
                                System.out.println(
                                                "Ingrearel id del proveedor del producto (Supplier)");
                                int findSupplierId = input.nextInt();
                                input.nextLine();
                                // Buscando supplier
                                MySupplier supplierId = new SupplierController(
                                                new SupplierRepository())
                                                .getSupplierById(findSupplierId);
                                if (supplierId.getSupplierID() == null) {
                                        System.out.println("El id del proveedor no existe");
                                        return;
                                }
                                System.out.println(
                                                "Ingresar el id de de la categoría que pertenece este producto");
                                int findCategorieId;
                                try {
                                        findCategorieId = input.nextInt();
                                        input.nextLine();

                                } catch (Exception e) {

                                        System.out.println("Error al introducir el id " + e);
                                        return;
                                }

                                // Buscando categorie
                                Categorie categorieId = new CategorieController(
                                                new CategorieRepository())
                                                .getCategorieById(findCategorieId);
                                if (categorieId.getCategoryID() == null) {
                                        System.out.println("El id de la categoría no existe");
                                        return;
                                }
                                System.out.println("Ingresar la cantidad por unidad");
                                String quantity = input.nextLine();
                                System.out.println("Ingresar el precio unitario");
                                double unitPrice = input.nextDouble();
                                input.nextLine();
                                System.out.println("Ingresar unidades en Stock");
                                int unitsInStock = input.nextInt();
                                input.nextLine();
                                System.out.println("Ingresar unidades ordenadas");
                                int unitsOnOrder = input.nextInt();
                                input.nextLine();
                                System.out.println("Ingresar nivel de orden");
                                int reorderLevel = input.nextInt();
                                System.out.println("Descontinuado. escribir (true/false)");
                                boolean discontinued = input.nextBoolean();

                                product = new Product.Builder()
                                                .productID(id)
                                                .productName(productieName)
                                                .supplierID(supplierId)
                                                .categoryID(categorieId)
                                                .quantityPerUnit(quantity)
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

                                        System.out.println("Error al introducirr el id " + e);
                                        return;
                                }
                                // Buscando e id de la orden
                                Order orderid = new OrderController(new OrderRepository())
                                                .getOrderById(findOrderId);

                                if (orderid.getOrderID() == null) {
                                        System.out.println("el id de la Orden no existe ");
                                        return;
                                }

                                System.out.println("Ingresarl el id del producto");
                                int findProductId;
                                try {
                                        findProductId = input.nextInt();
                                        input.nextLine();

                                } catch (Exception e) {

                                        System.out.println("Error al introducir id " + e);
                                        return;
                                }
                                Product productId = new ProductController(
                                                new ProductRepository())
                                                .getProductById(findProductId);
                                if (productId.getProductID() == null) {
                                        System.out.println("El id del producto no existe");
                                        return;
                                }
                                System.out.println("Ingresar precio Unitario");
                                int unitPrice = input.nextInt();
                                input.nextLine();
                                System.out.println("Ingresar cantidad");
                                int quantity = input.nextInt();
                                input.nextLine();
                                System.out.println("Ingresar descuento");
                                double discount = input.nextDouble();
                                input.nextLine();

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
