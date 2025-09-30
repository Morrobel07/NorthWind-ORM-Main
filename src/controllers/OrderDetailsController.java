package controllers;

import comons.IFile;
import models.OrderDetails;

import java.util.List;

public class OrderDetailsController {
      private final IFile<OrderDetails,Integer> repository ;
      

      public OrderDetailsController(IFile<OrderDetails,Integer> repository) {
          this.repository = repository;
      }

      public List<OrderDetails> getAllOrderDetails() {
          try{
              return repository.list();
          }catch (Exception e){
              System.out.println( "Error al obtener la informacion de la orden "+ e.getMessage());
              return null;
          }
      }

      public OrderDetails getOrderDetailsById(Integer id) {
          try {
              return repository.findById(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener la informacion "+ e.getMessage());
              return null;
          }
      }

      public void addOrderDetails(OrderDetails orderdetails) {
          try {
              List<OrderDetails> orderDetails = getAllOrderDetails();
              for (OrderDetails o : orderDetails) {
                  if (o.getOrderDetailsId() == orderdetails.getOrderDetailsId()) {
                      System.out.println("No puedes realizar un duplicado del id " + orderdetails.getOrderDetailsId());
                      return;
                  }

              }
              repository.addObject(orderdetails);
              System.out.println("Informacion agregada correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar la informacion"+ e.getMessage());
          }

      }

      public void updateOrderDetails(OrderDetails orderDetails) {
        try {
            repository.update(orderDetails);
            System.out.println("Informacion actualizada correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar la informacion"+ e.getMessage());
        }
      }

      public void deleteOrderDetails(Integer id) {
          try {
              repository.delete(id);
          }catch (Exception e) {
              System.out.println( "Error a eliminar la informacion"+ e.getMessage());
          }
      }


}
