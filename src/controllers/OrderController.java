package controllers;

import comons.IFile;
import models.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderController {
    private final IFile<Order, Integer> repository;

    public OrderController(IFile<Order, Integer> repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener todas las ordenes " + e.getMessage());
            return null;
        }
    }

    public Order getOrderById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las ordenes " + e.getMessage());
            return null;
        }
    }

    public void addOrder(Order order) {
        try {
            List<Order> orders = getAllOrders();
            for (Order o : orders) {
                if (o.getOrderID() == order.getOrderID()) {
                    System.out.println("No puedes realizar un duplicado del id " + order.getOrderID());
                    return;
                }
            }
            orders.add(order);
            System.out.println("Orden agregada correctamente");

            System.out.println("Orden agregada correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar la orden" + e.getMessage());
        }

    }

    public void updateOrder(Order order) {
        try {
            repository.update(order);
            System.out.println("Orden actualizada correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar la orden" + e.getMessage());
        }
    }

    public void deleteOrder(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar orden" + e.getMessage());
        }
    }

}
