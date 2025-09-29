package comons.Options;

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

public enum entitiesDelete {
    CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

    public void delete(int id) {
        switch (this) {
            case CUSTOMER: {
                new CustomerController(new CustomerRepository()).deleteCustomer(id);
                break;
            }
            case EMPLOYEE: {
                new EmployeeController(new EmployeeRepository()).deleteEmployee(id);
                break;
            }
            case SHIPPER: {
                new ShipperController(new ShipperRepository()).deleteShipper(id);
                break;
            }
            case ORDER: {
                new OrderController(new OrderRepository()).deleteOrder(id);
                break;
            }
            case SUPPLIER: {
                new SupplierController(new SupplierRepository()).deleteSupplier(id);
                break;
            }
            case CATEGORIE: {
                new CategorieController(new CategorieRepository()).deleteCategorie(id);
                break;
            }
            case PRODUCT: {
                new ProductController(new ProductRepository()).deleteProduct(id);
                break;
            }
            case ORDER_DETAILS: {
                new OrderDetailsController(new OrderDetailsRepository()).deleteOrderDetails(id);
                break;
            }

            default:

                break;
        }
    }
}
