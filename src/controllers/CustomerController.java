package controllers;

import comons.IFile;
import models.Customer;
import repository.CustomerRepository;

import java.util.List;

public class CustomerController {
    private final IFile<Customer, Integer> repository;

    public CustomerController(IFile<Customer, Integer> repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los clientes " + e.getMessage());
            return null;
        }
    }

    public Customer getCustomerById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los clientes " + e.getMessage());
            return null;
        }
    }

    public void addCustomer(Customer customer) {
        try {
            List<Customer> customers = getAllCustomers();


            for (Customer c : customers) {
                if (c.getCustomerID() == customer.getCustomerID()) {
                    System.out.println("No puedes realizar un duplicado del id " + customer.getCustomerID());
                    return;
                }
            }
            customers.add(customer);
            System.out.println("Cliente agregado correctamente");

        } catch (Exception e) {
            System.out.println("Error al agregar cliente" + e.getMessage());
        }

    }

    public void updateCustomer(Customer customer) {
        try {
            repository.update(customer);
            System.out.println("Cliente actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente" + e.getMessage());
        }
    }

    public void deleteCustomer(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente" + e.getMessage());
        }
    }

}
