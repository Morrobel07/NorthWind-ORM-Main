package comons.Options;

import models.*;
import repository.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public enum updateEntities {
    CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

    Scanner input = new Scanner(System.in);

    public void update(int id) {
        switch (this) {
            case CUSTOMER: {
                boolean condition;
                do {
                    try {
                        System.out.println("Ingresa el id del customer que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        CustomerRepository customerRepository = new CustomerRepository();
                        Customer customer = customerRepository.findById(id);
                        if (customer != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");
                            System.out.println("Ingrese el nuevo Company Name (actual: " + customer.getCompanyName() + "):");
                            String companyName = input.nextLine();
                            if (!companyName.trim().isEmpty()) {
                                customer.setCompanyName(companyName);
                            }

                            System.out.println("Ingrese el nuevo Contact Name (actual: " + customer.getContactName() + "):");
                            String contactName = input.nextLine();
                            if (!contactName.trim().isEmpty()) {
                                customer.setContactName(contactName);
                            }

                            System.out.println("Ingrese el nuevo Contact Title (actual: " + customer.getContactTitle() + "):");
                            String contactTitle = input.nextLine();
                            if (!contactTitle.trim().isEmpty()) {
                                customer.setContactTitle(contactTitle);
                            }

                            System.out.println("Ingrese la nueva Address (actual: " + customer.getAddress() + "):");
                            String address = input.nextLine();
                            if (!address.trim().isEmpty()) {
                                customer.setAddress(address);
                            }

                            System.out.println("Ingrese la nueva City (actual: " + customer.getCity() + "):");
                            String city = input.nextLine();
                            if (!city.trim().isEmpty()) {
                                customer.setCity(city);
                            }

                            System.out.println("Ingrese la nueva Region (actual: " + customer.getRegion() + "):");
                            String region = input.nextLine();
                            if (!region.trim().isEmpty()) {
                                customer.setRegion(region);
                            }

                            System.out.println("Ingrese el nuevo Postal Code (actual: " + customer.getPostalCode() + "):");
                            String postalCode = input.nextLine();
                            if (!postalCode.trim().isEmpty()) {
                                customer.setPostalCode(postalCode);
                            }

                            System.out.println("Ingrese el nuevo Country (actual: " + customer.getCountry() + "):");
                            String country = input.nextLine();
                            if (!country.trim().isEmpty()) {
                                customer.setCountry(country);
                            }

                            System.out.println("Ingrese el nuevo Phone (actual: " + customer.getPhone() + "):");
                            String phone = input.nextLine();
                            if (!phone.trim().isEmpty()) {
                                customer.setPhone(phone);
                            }

                            System.out.println("Ingrese el nuevo Fax (actual: " + customer.getFax() + "):");
                            String fax = input.nextLine();
                            if (!fax.trim().isEmpty()) {
                                customer.setFax(fax);
                            }

                            customerRepository.update(customer);
                            System.out.println("¡Registro actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }

                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Ingresa el id del Employee que desea actualizar");
                        id = input.nextInt();
                        input.nextLine(); // Consume newline
                        EmployeeRepository employeeRepository = new EmployeeRepository();
                        Employee employee = employeeRepository.findById(id);
                        if (employee != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            System.out.println("Ingrese el nuevo Last Name (actual: " + employee.getLastName() + "):");
                            String lastName = input.nextLine();
                            if (!lastName.trim().isEmpty()) {
                                employee.setLastName(lastName);
                            }

                            System.out.println("Ingrese el nuevo First Name (actual: " + employee.getFirstName() + "):");
                            String firstName = input.nextLine();
                            if (!firstName.trim().isEmpty()) {
                                employee.setFirstName(firstName);
                            }

                            System.out.println("Ingrese el nuevo Title (actual: " + employee.getTitle() + "):");
                            String title = input.nextLine();
                            if (!title.trim().isEmpty()) {
                                employee.setTitle(title);
                            }

                            System.out.println("Ingrese el nuevo Title of Courtesy (actual: " + employee.getTitleOfCourtesy() + "):");
                            String titleOfCourtesy = input.nextLine();
                            if (!titleOfCourtesy.trim().isEmpty()) {
                                employee.setTitleOfCourtesy(titleOfCourtesy);
                            }

                            boolean validDate;
                            do {
                                System.out.println("Ingrese la nueva Birth Date (yyyy-MM-dd) (actual: " + employee.getBirthDate() + "):");
                                String birthDateStr = input.nextLine();
                                if (!birthDateStr.trim().isEmpty()) {
                                    try {
                                        employee.setBirthDate(LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE));
                                        validDate = true;
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Formato de fecha inválido. Use yyyy-MM-dd.");
                                        validDate = false;
                                    }
                                } else {
                                    validDate = true; // User skipped
                                }
                            } while (!validDate);

                            do {
                                System.out.println("Ingrese la nueva Hire Date (yyyy-MM-dd) (actual: " + employee.getHireDate() + "):");
                                String hireDateStr = input.nextLine();
                                if (!hireDateStr.trim().isEmpty()) {
                                    try {
                                        employee.setHireDate(LocalDate.parse(hireDateStr, DateTimeFormatter.ISO_LOCAL_DATE));
                                        validDate = true;
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Formato de fecha inválido. Use yyyy-MM-dd.");
                                        validDate = false;
                                    }
                                } else {
                                    validDate = true; // User skipped
                                }
                            } while (!validDate);

                            System.out.println("Ingrese la nueva Address (actual: " + employee.getAddress() + "):");
                            String address = input.nextLine();
                            if (!address.trim().isEmpty()) {
                                employee.setAddress(address);
                            }

                            System.out.println("Ingrese la nueva City (actual: " + employee.getCity() + "):");
                            String city = input.nextLine();
                            if (!city.trim().isEmpty()) {
                                employee.setCity(city);
                            }

                            System.out.println("Ingrese la nueva Region (actual: " + employee.getRegion() + "):");
                            String region = input.nextLine();
                            if (!region.trim().isEmpty()) {
                                employee.setRegion(region);
                            }

                            System.out.println("Ingrese el nuevo Postal Code (actual: " + employee.getPostalCode() + "):");
                            String postalCode = input.nextLine();
                            if (!postalCode.trim().isEmpty()) {
                                employee.setPostalCode(postalCode);
                            }

                            System.out.println("Ingrese el nuevo Country (actual: " + employee.getCountry() + "):");
                            String country = input.nextLine();
                            if (!country.trim().isEmpty()) {
                                employee.setCountry(country);
                            }

                            System.out.println("Ingrese el nuevo Home Phone (actual: " + employee.getHomePhone() + "):");
                            String homePhone = input.nextLine();
                            if (!homePhone.trim().isEmpty()) {
                                employee.setHomePhone(homePhone);
                            }

                            System.out.println("Ingrese la nueva Extension (actual: " + employee.getExtension() + "):");
                            String extension = input.nextLine();
                            if (!extension.trim().isEmpty()) {
                                employee.setExtension(extension);
                            }

                            System.out.println("Ingrese la nueva Photo URL (actual: " + employee.getPhoto() + "):");
                            String photo = input.nextLine();
                            if (!photo.trim().isEmpty()) {
                                employee.setPhoto(photo);
                            }

                            System.out.println("Ingrese las nuevas Notes (actual: " + employee.getNotes() + "):");
                            String notes = input.nextLine();
                            if (!notes.trim().isEmpty()) {
                                employee.setNotes(notes);
                            }

                            boolean validInt;
                            do {
                                System.out.println("Ingrese el nuevo Reports To (ID) (actual: " + employee.getReportsTo() + "):");
                                String reportsToStr = input.nextLine();
                                if (!reportsToStr.trim().isEmpty()) {
                                    try {
                                        employee.setReportsTo(Integer.parseInt(reportsToStr));
                                        validInt = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("ID inválido. Ingrese un número.");
                                        validInt = false;
                                    }
                                } else {
                                    validInt = true; // User skipped
                                }
                            } while (!validInt);

                            System.out.println("Ingrese el nuevo Photo Path (actual: " + employee.getPhotoPath() + "):");
                            String photoPath = input.nextLine();
                            if (!photoPath.trim().isEmpty()) {
                                employee.setPhotoPath(photoPath);
                            }

                            employeeRepository.update(employee);
                            System.out.println("¡Registro de empleado actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print("*******: Error");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }

                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
                        System.out.println("El valor del id es inválido....");
                        condition = true;
                        input.nextLine(); // consume the invalid input
                    }

                } while (condition);
                break;
            }
            case SHIPPER: {
                boolean condition;
                do {
                    try {
                        System.out.println("Ingresa el id del Shipper que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        ShipperRepository shipperRepository = new ShipperRepository();
                        Shipper shipper = shipperRepository.findById(id);
                        if (shipper != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            System.out.println("Ingrese el nuevo Company Name (actual: " + shipper.getCompanyName() + "):");
                            String companyName = input.nextLine();
                            if (!companyName.trim().isEmpty()) {
                                shipper.setCompanyName(companyName);
                            }

                            System.out.println("Ingrese el nuevo Phone (actual: " + shipper.getPhone() + "):");
                            String phone = input.nextLine();
                            if (!phone.trim().isEmpty()) {
                                shipper.setPhone(phone);
                            }

                            shipperRepository.update(shipper);
                            System.out.println("¡Registro de shipper actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Ingresa el id del Supplier que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        SupplierRepository supplierRepository = new SupplierRepository();
                        Suppliers supplier = supplierRepository.findById(id);
                        if (supplier != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            System.out.println("Ingrese el nuevo Company Name (actual: " + supplier.getCompanyName() + "):");
                            String companyName = input.nextLine();
                            if (!companyName.trim().isEmpty()) {
                                supplier.setCompanyName(companyName);
                            }

                            System.out.println("Ingrese el nuevo Contact Name (actual: " + supplier.getContactName() + "):");
                            String contactName = input.nextLine();
                            if (!contactName.trim().isEmpty()) {
                                supplier.setContactName(contactName);
                            }

                            System.out.println("Ingrese el nuevo Contact Title (actual: " + supplier.getContactTitle() + "):");
                            String contactTitle = input.nextLine();
                            if (!contactTitle.trim().isEmpty()) {
                                supplier.setContactTitle(contactTitle);
                            }

                            System.out.println("Ingrese la nueva Address (actual: " + supplier.getAddress() + "):");
                            String address = input.nextLine();
                            if (!address.trim().isEmpty()) {
                                supplier.setAddress(address);
                            }

                            System.out.println("Ingrese la nueva City (actual: " + supplier.getCity() + "):");
                            String city = input.nextLine();
                            if (!city.trim().isEmpty()) {
                                supplier.setCity(city);
                            }

                            System.out.println("Ingrese la nueva Region (actual: " + supplier.getRegion() + "):");
                            String region = input.nextLine();
                            if (!region.trim().isEmpty()) {
                                supplier.setRegion(region);
                            }

                            System.out.println("Ingrese el nuevo Postal Code (actual: " + supplier.getPostalCode() + "):");
                            String postalCode = input.nextLine();
                            if (!postalCode.trim().isEmpty()) {
                                supplier.setPostalCode(postalCode);
                            }

                            System.out.println("Ingrese el nuevo Country (actual: " + supplier.getCountry() + "):");
                            String country = input.nextLine();
                            if (!country.trim().isEmpty()) {
                                supplier.setCountry(country);
                            }

                            System.out.println("Ingrese el nuevo Phone (actual: " + supplier.getPhone() + "):");
                            String phone = input.nextLine();
                            if (!phone.trim().isEmpty()) {
                                supplier.setPhone(phone);
                            }

                            System.out.println("Ingrese el nuevo Fax (actual: " + supplier.getFax() + "):");
                            String fax = input.nextLine();
                            if (!fax.trim().isEmpty()) {
                                supplier.setFax(fax);
                            }

                            System.out.println("Ingrese el nuevo Home Page (actual: " + supplier.getHomePage() + "):");
                            String homePage = input.nextLine();
                            if (!homePage.trim().isEmpty()) {
                                supplier.setHomePage(homePage);
                            }

                            supplierRepository.update(supplier);
                            System.out.println("¡Registro de supplier actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Ingresa el id de la Categorie que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        CategorieRepository categorieRepository = new CategorieRepository();
                        Categorie categorie = categorieRepository.findById(id);
                        if (categorie != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            System.out.println("Ingrese el nuevo Category Name (actual: " + categorie.getCategoryName() + "):");
                            String categoryName = input.nextLine();
                            if (!categoryName.trim().isEmpty()) {
                                categorie.setCategoryName(categoryName);
                            }

                            System.out.println("Ingrese la nueva Description (actual: " + categorie.getDescription() + "):");
                            String description = input.nextLine();
                            if (!description.trim().isEmpty()) {
                                categorie.setDescription(description);
                            }

                            System.out.println("Ingrese la nueva Picture URL (actual: " + categorie.getPicture() + "):");
                            String picture = input.nextLine();
                            if (!picture.trim().isEmpty()) {
                                categorie.setPicture(picture);
                            }

                            categorieRepository.update(categorie);
                            System.out.println("¡Registro de categorie actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Ingresa el id del Product que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        ProductRepository productRepository = new ProductRepository();
                        Product product = productRepository.findById(id);
                        if (product != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            System.out.println("Ingrese el nuevo Product Name (actual: " + product.getProductName() + "):");
                            String productName = input.nextLine();
                            if (!productName.trim().isEmpty()) {
                                product.setProductName(productName);
                            }

                            // Handle Supplier FK
                            System.out.println("Ingrese el nuevo Supplier ID (actual: " + (product.getSupplierID() != null ? product.getSupplierID().getSupplierID() : "N/A") + "):");
                            String supplierIdStr = input.nextLine();
                            if(!supplierIdStr.trim().isEmpty()){
                                try {
                                    int supplierId = Integer.parseInt(supplierIdStr);
                                    Suppliers newSupplier = new SupplierRepository().findById(supplierId);
                                    if(newSupplier != null){
                                        product.setSupplierID(newSupplier);
                                    } else {
                                        System.out.println("Supplier con ID " + supplierId + " no encontrado. Se mantiene el valor anterior.");
                                    }
                                } catch (NumberFormatException e){
                                    System.out.println("ID de Supplier inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Handle Category FK
                            System.out.println("Ingrese el nuevo Category ID (actual: " + (product.getCategoryID() != null ? product.getCategoryID().getCategoryID() : "N/A") + "):");
                            String categoryIdStr = input.nextLine();
                            if(!categoryIdStr.trim().isEmpty()){
                                try {
                                    int categoryId = Integer.parseInt(categoryIdStr);
                                    Categorie newCategorie = new CategorieRepository().findById(categoryId);
                                    if(newCategorie != null){
                                        product.setCategoryID(newCategorie);
                                    } else {
                                        System.out.println("Categoria con ID " + categoryId + " no encontrada. Se mantiene el valor anterior.");
                                    }
                                } catch (NumberFormatException e){
                                    System.out.println("ID de Categoria inválido. Se mantiene el valor anterior.");
                                }
                            }

                            System.out.println("Ingrese la nueva Quantity Per Unit (actual: " + product.getQuantityPerUnit() + "):");
                            String quantityPerUnit = input.nextLine();
                            if (!quantityPerUnit.trim().isEmpty()) {
                                product.setQuantityPerUnit(quantityPerUnit);
                            }

                            // Handle double
                            System.out.println("Ingrese el nuevo Unit Price (actual: " + product.getUnitPrice() + "):");
                            String unitPriceStr = input.nextLine();
                            if(!unitPriceStr.trim().isEmpty()){
                                try {
                                    product.setUnitPrice(Double.parseDouble(unitPriceStr));
                                } catch (NumberFormatException e){
                                    System.out.println("Precio unitario inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Handle int for unitsInStock, unitsOnOrder, reorderLevel
                            System.out.println("Ingrese las nuevas Units In Stock (actual: " + product.getUnitsInStock() + "):");
                            String unitsInStockStr = input.nextLine();
                            if(!unitsInStockStr.trim().isEmpty()){
                                try {
                                    product.setUnitsInStock(Integer.parseInt(unitsInStockStr));
                                } catch (NumberFormatException e){
                                    System.out.println("Unidades en Stock inválidas. Se mantiene el valor anterior.");
                                }
                            }

                            System.out.println("Ingrese las nuevas Units On Order (actual: " + product.getUnitsOnOrder() + "):");
                            String unitsOnOrderStr = input.nextLine();
                            if(!unitsOnOrderStr.trim().isEmpty()){
                                try {
                                    product.setUnitsOnOrder(Integer.parseInt(unitsOnOrderStr));
                                } catch (NumberFormatException e){
                                    System.out.println("Unidades en Orden inválidas. Se mantiene el valor anterior.");
                                }
                            }

                            System.out.println("Ingrese el nuevo Reorder Level (actual: " + product.getReorderLevel() + "):");
                            String reorderLevelStr = input.nextLine();
                            if(!reorderLevelStr.trim().isEmpty()){
                                try {
                                    product.setReorderLevel(Integer.parseInt(reorderLevelStr));
                                } catch (NumberFormatException e){
                                    System.out.println("Nivel de Reorden inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Handle boolean
                            System.out.println("¿Está discontinuado? (true/false) (actual: " + product.isDiscontinued() + "):");
                            String discontinuedStr = input.nextLine();
                            if(!discontinuedStr.trim().isEmpty()){
                                if(discontinuedStr.equalsIgnoreCase("true")){
                                    product.setDiscontinued(true);
                                } else if (discontinuedStr.equalsIgnoreCase("false")){
                                    product.setDiscontinued(false);
                                } else {
                                    System.out.println("Valor inválido para 'discontinued'. Se mantiene el valor anterior.");
                                }
                            }

                            productRepository.update(product);
                            System.out.println("¡Registro de product actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Ingresa el id de la Order que desea actualizar");
                        id = input.nextInt();
                        input.nextLine();
                        OrderRepository orderRepository = new OrderRepository();
                        Order order = orderRepository.findById(id);
                        if (order != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            // Customer FK
                            System.out.println("Ingrese el nuevo Customer ID (actual: " + (order.getCustomersID() != null ? order.getCustomersID().getCustomerID() : "N/A") + "):");
                            String customerIdStr = input.nextLine();
                            if (!customerIdStr.trim().isEmpty()) {
                                try {
                                    int customerId = Integer.parseInt(customerIdStr);
                                    Customer newCustomer = new CustomerRepository().findById(customerId);
                                    if (newCustomer != null) {
                                        order.setCustomersID(newCustomer);
                                    } else {
                                        System.out.println("Customer con ID " + customerId + " no encontrado. Se mantiene el valor anterior.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("ID de Customer inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Employee FK
                            System.out.println("Ingrese el nuevo Employee ID (actual: " + (order.getEmployeeID() != null ? order.getEmployeeID().getEmployeeID() : "N/A") + "):");
                            String employeeIdStr = input.nextLine();
                            if (!employeeIdStr.trim().isEmpty()) {
                                try {
                                    int employeeId = Integer.parseInt(employeeIdStr);
                                    Employee newEmployee = new EmployeeRepository().findById(employeeId);
                                    if (newEmployee != null) {
                                        order.setEmployeeID(newEmployee);
                                    } else {
                                        System.out.println("Employee con ID " + employeeId + " no encontrado. Se mantiene el valor anterior.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("ID de Employee inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Dates
                            System.out.println("Ingrese la nueva Order Date (yyyy-MM-dd) (actual: " + order.getOrderDate() + "):");
                            String orderDateStr = input.nextLine();
                            if (!orderDateStr.trim().isEmpty()) {
                                try {
                                    order.setOrderDate(LocalDate.parse(orderDateStr));
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de fecha inválido. Se mantiene el valor anterior.");
                                }
                            }

                            System.out.println("Ingrese la nueva Required Date (yyyy-MM-dd) (actual: " + order.getRequiredDate() + "):");
                            String requiredDateStr = input.nextLine();
                            if (!requiredDateStr.trim().isEmpty()) {
                                try {
                                    order.setRequiredDate(LocalDate.parse(requiredDateStr));
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de fecha inválido. Se mantiene el valor anterior.");
                                }
                            }

                            System.out.println("Ingrese la nueva Shipped Date (yyyy-MM-dd) (actual: " + order.getShippedDate() + "):");
                            String shippedDateStr = input.nextLine();
                            if (!shippedDateStr.trim().isEmpty()) {
                                try {
                                    order.setShippedDate(LocalDate.parse(shippedDateStr));
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de fecha inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Shipper FK
                            System.out.println("Ingrese el nuevo Shipper ID (Ship Via) (actual: " + (order.getShipVia() != null ? order.getShipVia().getShipperID() : "N/A") + "):");
                            String shipperIdStr = input.nextLine();
                            if (!shipperIdStr.trim().isEmpty()) {
                                try {
                                    int shipperId = Integer.parseInt(shipperIdStr);
                                    Shipper newShipper = new ShipperRepository().findById(shipperId);
                                    if (newShipper != null) {
                                        order.setShipVia(newShipper);
                                    } else {
                                        System.out.println("Shipper con ID " + shipperId + " no encontrado. Se mantiene el valor anterior.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("ID de Shipper inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Freight
                            System.out.println("Ingrese el nuevo Freight (actual: " + order.getFreight() + "):");
                            String freightStr = input.nextLine();
                            if (!freightStr.trim().isEmpty()) {
                                try {
                                    order.setFreight(Double.parseDouble(freightStr));
                                } catch (NumberFormatException e) {
                                    System.out.println("Valor de Freight inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Ship Info
                            System.out.println("Ingrese el nuevo Ship Name (actual: " + order.getShipName() + "):");
                            String shipName = input.nextLine();
                            if (!shipName.trim().isEmpty()) {
                                order.setShipName(shipName);
                            }

                            System.out.println("Ingrese la nueva Ship Address (actual: " + order.getShipAddress() + "):");
                            String shipAddress = input.nextLine();
                            if (!shipAddress.trim().isEmpty()) {
                                order.setShipAddress(shipAddress);
                            }

                            System.out.println("Ingrese la nueva Ship City (actual: " + order.getShipCity() + "):");
                            String shipCity = input.nextLine();
                            if (!shipCity.trim().isEmpty()) {
                                order.setShipCity(shipCity);
                            }

                            System.out.println("Ingrese la nueva Ship Region (actual: " + order.getShipRegion() + "):");
                            String shipRegion = input.nextLine();
                            if (!shipRegion.trim().isEmpty()) {
                                order.setShipRegion(shipRegion);
                            }

                            System.out.println("Ingrese el nuevo Ship Postal Code (actual: " + order.getShipPostalCode() + "):");
                            String shipPostalCode = input.nextLine();
                            if (!shipPostalCode.trim().isEmpty()) {
                                order.setShipPostalCode(shipPostalCode);
                            }

                            System.out.println("Ingrese el nuevo Ship Country (actual: " + order.getShipCountry() + "):");
                            String shipCountry = input.nextLine();
                            if (!shipCountry.trim().isEmpty()) {
                                order.setShipCountry(shipCountry);
                            }

                            orderRepository.update(order);
                            System.out.println("¡Registro de order actualizado exitosamente!");
                            condition = false;
                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El id que intenta actualizar no existe");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
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
                        System.out.println("Actualización de Order Details requiere OrderID y ProductID.");
                        System.out.println("Ingrese el OrderID:");
                        int orderId = input.nextInt();
                        System.out.println("Ingrese el ProductID:");
                        int productId = input.nextInt();
                        input.nextLine();

                        OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepository();
                        OrderDetails orderDetails = orderDetailsRepository.findById(orderId);
                        ProductRepository productRepository = new ProductRepository();
                        Product product = productRepository.findById(productId);

                        if (orderDetails != null && product != null) {
                            System.out.println("*****Actualizando registro! Deje el campo en blanco si no desea actualizarlo.");

                            // Unit Price
                            System.out.println("Ingrese el nuevo Unit Price (actual: " + orderDetails.getUnitPrice() + "):");
                            String unitPriceStr = input.nextLine();
                            if (!unitPriceStr.trim().isEmpty()) {
                                try {
                                    orderDetails.setUnitPrice(Double.parseDouble(unitPriceStr));
                                } catch (NumberFormatException e) {
                                    System.out.println("Precio unitario inválido. Se mantiene el valor anterior.");
                                }
                            }

                            // Quantity
                            System.out.println("Ingrese la nueva Quantity (actual: " + orderDetails.getQuantity() + "):");
                            String quantityStr = input.nextLine();
                            if (!quantityStr.trim().isEmpty()) {
                                try {
                                    orderDetails.setQuantity(Integer.parseInt(quantityStr));
                                } catch (NumberFormatException e) {
                                    System.out.println("Cantidad inválida. Se mantiene el valor anterior.");
                                }
                            }

                            // Discount
                            System.out.println("Ingrese el nuevo Discount (actual: " + orderDetails.getDiscount() + "):");
                            String discountStr = input.nextLine();
                            if (!discountStr.trim().isEmpty()) {
                                try {
                                    orderDetails.setDiscount(Double.parseDouble(discountStr));
                                } catch (NumberFormatException e) {
                                    System.out.println("Descuento inválido. Se mantiene el valor anterior.");
                                }
                            }

                            orderDetailsRepository.update(orderDetails);
                            System.out.println("¡Registro de order detail actualizado exitosamente!");
                            condition = false;

                        } else {
                            System.out.print(" *****ERROR ");
                            System.out.println("El registro de Order Detail con OrderID " + orderId + " y ProductID " + productId + " no existe.");
                            condition = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("*****!ERROR ");
                        System.out.println("El valor de uno de los IDs es inválido....");
                        condition = true;
                        input.nextLine();
                    }
                } while (condition);


            }
                break;
            default:
                break;
        }
    }
}
