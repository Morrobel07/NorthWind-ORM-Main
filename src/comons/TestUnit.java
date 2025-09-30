//package comons; // Sugerencia: Renombrar a "commons" si fue un error tipográfico.
//
//import models.*; // Importamos todas las clases del modelo
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Clase de pruebas unitarias para las entidades del modelo Northwind.
// */
//class TestUnit {
//
//    // Para las pruebas que involucran relaciones (como Order -> Customer),
//    // podemos crear instancias de prueba.
//    private Customer testCustomer;
//    private Categorie testCategory;
//    private Suppliers testSupplier;
//    private Employee testEmployee;
//    private Shipper testShipper;
//
//    // Esta anotación ejecuta el método antes de CADA prueba en la clase.
//    // Es útil para inicializar objetos y asegurar un estado limpio.
//    @BeforeEach
//    void setUp() {
//        System.out.println("Preparando una nueva prueba...");
//        // Inicializamos objetos dummy usando sus builders para asegurar un estado
//        // consistente.
//        testCustomer = new Customer.Builder().customerID(999).companyName("Test Customer").build();
//        testCategory = new Categorie.Builder().categoryID(999).categoryName("Test Category").build();
//        testSupplier = new Suppliers.Builder().supplierID(999).companyName("Test Supplier").build();
//        testEmployee = new Employee.Builder().employeeID(999).firstName("Test").lastName("Employee").build();
//        testShipper = new Shipper.Builder().shipperID(999).companyName("Test Shipper").build();
//    }
//
//    @Test
//    @DisplayName("Prueba de suma simple para verificar configuración de JUnit")
//    void simpleAdditionTest() {
//        // 1. Arrange
//        int a = 2;
//        int b = 3;
//        int expectedResult = 5;
//
//        // 2. Act
//        int actualResult = a + b;
//
//        // 3. Assert
//        assertEquals(expectedResult, actualResult, "La suma de 2 + 3 debería ser 5");
//    }
//
//    @Test
//    @DisplayName("Debería crear un objeto Product correctamente usando el Builder")
//    void testProductBuilder() {
//        // 1. Arrange (Preparar)
//        String expectedName = "Chai";
//        double expectedPrice = 18.00;
//        int expectedStock = 39;
//
//        // 2. Act (Actuar) - Usamos el Builder para construir el objeto
//        Product product = new Product.Builder()
//                .productID(1)
//                .productName(expectedName)
//                .supplierID(testSupplier)
//                .categoryID(testCategory)
//                .quantityPerUnit("10 boxes x 20 bags")
//                .unitPrice(expectedPrice)
//                .unitsInStock(expectedStock)
//                .unitsOnOrder(0)
//                .reorderLevel(10)
//                .discontinued(false)
//                .build();
//
//        // 3. Assert (Afirmar)
//        assertNotNull(product);
//        assertEquals(1, product.getProductID());
//        assertEquals(expectedName, product.getProductName());
//        assertEquals(expectedPrice, product.getUnitPrice());
//        assertEquals(expectedStock, product.getUnitsInStock());
//        assertFalse(product.isDiscontinued());
//    }
//
//    @Test
//    @DisplayName("Debería crear un objeto Customer correctamente usando el Builder")
//    void testCustomerBuilder() {
//        // 1. Arrange
//        String expectedCompany = "Alfreds Futterkiste";
//        String expectedCity = "Berlin";
//
//        // 2. Act
//        Customer customer = new Customer.Builder()
//                .customerID(1) // En la BD es un String 'ALFKI', pero el modelo usa int
//                .companyName(expectedCompany)
//                .contactName("Maria Anders")
//                .contactTitle("Sales Representative")
//                .address("Obere Str. 57")
//                .city(expectedCity)
//                .postalCode("12209")
//                .country("Germany")
//                .phone("030-0074321")
//                .build();
//
//        // 3. Assert
//        assertNotNull(customer);
//        assertEquals(1, customer.getCustomerID());
//        assertEquals(expectedCompany, customer.getCompanyName());
//        assertEquals(expectedCity, customer.getCity());
//    }
//
//    @Test
//    @DisplayName("Debería crear un objeto Order correctamente usando el Builder")
//    void testOrderBuilder() {
//        // 1. Arrange
//        LocalDate orderDate = LocalDate.of(2024, 5, 21);
//        String shipCity = "Reims";
//
//        // 2. Act
//        Order order = new Order.Builder()
//                .orderID(10248)
//                .customersID(testCustomer)
//                .employeeID(testEmployee)
//                .orderDate(orderDate)
//                .shipVia(testShipper)
//                .shipCity(shipCity)
//                .build();
//
//        // 3. Assert
//        assertNotNull(order);
//        assertEquals(10248, order.getOrderID());
//        assertEquals(orderDate, order.getOrderDate());
//        assertEquals(shipCity, order.getShipCity());
//        assertSame(testCustomer, order.getCustomersID(),
//                "El cliente de la orden debe ser la misma instancia de prueba");
//    }
//
//    @Test
//    @DisplayName("Debería crear un objeto Employee correctamente usando el Builder")
//    void testEmployeeBuilder() {
//        // 1. Arrange
//        String expectedFirstName = "Nancy";
//        String expectedLastName = "Davolio";
//        String expectedTitle = "Sales Representative";
//        LocalDate hireDate = LocalDate.of(1992, 5, 1);
//
//        // 2. Act
//        Employee employee = new Employee.Builder()
//                .employeeID(1)
//                .lastName(expectedLastName)
//                .firstName(expectedFirstName)
//                .title(expectedTitle)
//                .hireDate(hireDate)
//                .country("USA")
//                .build();
//
//        // 3. Assert
//        assertNotNull(employee);
//        assertEquals(1, employee.getEmployeeID());
//        assertEquals(expectedFirstName, employee.getFirstName());
//        assertEquals(expectedLastName, employee.getLastName());
//        assertEquals(expectedTitle, employee.getTitle());
//        assertEquals(hireDate, employee.getHireDate());
//    }
//
//    @Test
//    @DisplayName("Debería crear un objeto Shipper correctamente usando el Builder")
//    void testShipperBuilder() {
//        // 1. Arrange & 2. Act
//        Shipper shipper = new Shipper.Builder()
//                .shipperID(1)
//                .companyName("Speedy Express")
//                .phone("(503) 555-9831")
//                .build();
//
//        // 3. Assert
//        assertNotNull(shipper);
//        assertEquals(1, shipper.getShipperID());
//        assertEquals("Speedy Express", shipper.getCompanyName());
//        assertEquals("(503) 555-9831", shipper.getPhone());
//    }
//}
