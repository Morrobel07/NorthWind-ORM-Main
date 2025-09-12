package controllers;

import comons.IFile;
import models.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderController {
      private IFile<Order> repository ;

      public OrderController(IFile<Order> repository) {
          this.repository = repository;
      }

      public List<Order> getAllOrders() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener todas las ordenes "+ e.getMessage());
              return null;
          }
      }

      public Order getOrderById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener todas las ordenes "+ e.getMessage());
              return null;
          }
      }

      public void addOrder(Order order) {
          try {
              List<Order> orders =  getAllOrders();
              orders.add(order);
              repository.Save(orders);
              System.out.println("Orden agregada correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar la orden"+ e.getMessage());
          }

      }

      public void updateOrder(Order order) {
        try {
            repository.Update(order);
            System.out.println("Orden actualizada correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar la orden"+ e.getMessage());
        }
      }

      public void deleteOrder(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error al eliminar orden"+ e.getMessage());
          }
      }


}
