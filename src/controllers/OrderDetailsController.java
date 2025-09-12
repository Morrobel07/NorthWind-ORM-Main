package controllers;

import comons.IFile;
import models.OrderDetails;
import repository.OrderDetailsRepository;

import java.util.List;

public class OrderDetailsController {
      private final IFile<OrderDetails> repository ;

      public OrderDetailsController(IFile<OrderDetails> repository) {
          this.repository = repository;
      }

      public List<OrderDetails> getAllOrderDetails() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener la informacion de la orden "+ e.getMessage());
              return null;
          }
      }

      public OrderDetails getOrderDetailsById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener la informacion "+ e.getMessage());
              return null;
          }
      }

      public void addOrderDetails(OrderDetails orderdetails) {
          try {
              List<OrderDetails> orderDetails2 =  getAllOrderDetails();
              orderDetails2.add(orderdetails);
              repository.Save(orderDetails2);
              System.out.println("Informacion agregada correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar la informacion"+ e.getMessage());
          }

      }

      public void updateOrderDetails(OrderDetails orderDetails) {
        try {
            repository.Update(orderDetails);
            System.out.println("Informacion actualizada correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar la informacion"+ e.getMessage());
        }
      }

      public void deleteOrderDetails(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error a eliminar la informacion"+ e.getMessage());
          }
      }


}
