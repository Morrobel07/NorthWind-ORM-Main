package controllers;

import comons.IFile;
import models.Customer;
import repository.CustomerRepository;

import java.util.List;

public class CustomerController {
      private final IFile<Customer> repository ;

      public CustomerController (IFile<Customer> repository) {
          this.repository = repository;
      }

      public List<Customer> getAllCustomers() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener todos los clientes "+ e.getMessage());
              return null;
          }
      }

      public Customer getCustomerById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener todos los clientes "+ e.getMessage());
              return null;
          }
      }

      public void addCustomer(Customer customer) {
          try {
              List<Customer> customers =  getAllCustomers();

              int newId = customers.isEmpty() ?
                      1 : customers.stream().
                              mapToInt(e -> e.getCustomerID()).
                              max().orElse(0) +1
                              ;
              customer.setCustomerID(newId);
              customers.add(customer);
              repository.Save(customers);
              System.out.println("Cliente agregado correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar cliente"+ e.getMessage());
          }

      }

      public void updateCustomer(Customer customer) {
        try {
            repository.Update(customer);
            System.out.println("Cliente actualizado correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar cliente"+ e.getMessage());
        }
      }

      public void deleteCustomer(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error al eliminar cliente"+ e.getMessage());
          }
      }


}
