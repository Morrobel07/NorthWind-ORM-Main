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

public enum listEntities {
    CUSTOMER, EMPLOYEE, SHIPPER, ORDER, SUPPLIER, CATEGORIE, PRODUCT, ORDER_DETAILS;

    public void find(int id) {

        switch (this) {
            case CUSTOMER: {
                System.out.println(new CustomerController(new CustomerRepository()).getCustomerById(id));
                break;
            }
            case EMPLOYEE: {
                System.out.println(new EmployeeController(new EmployeeRepository()).getEmployeeById(id));
                break;
            }
            case SHIPPER: {
                System.out.println(new ShipperController(new ShipperRepository()).getShipperById(id));
                break;
            }
            case ORDER: {
                System.out.println(new OrderController(new OrderRepository()).getOrderById(id));
                break;
            }
            case SUPPLIER: {
                System.out.println(new SupplierController(new SupplierRepository()).getSupplierById(id));
                break;
            }
            case CATEGORIE: {
                System.out.println(new CategorieController(new CategorieRepository()).getCategorieById(id));
                break;
            }
            case PRODUCT: {
                System.out.println(new ProductController(new ProductRepository()).getProductById(id));
                break;
            }
            case ORDER_DETAILS: {
                System.out.println(new OrderDetailsController(new OrderDetailsRepository()).getOrderDetailsById(id));
                break;
            }

            default:

                break;
        }
    }
}
