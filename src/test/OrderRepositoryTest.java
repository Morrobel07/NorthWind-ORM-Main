package test;

import org.junit.jupiter.api.Test;
import models.Order;
import repository.OrderRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    @Test
    void testListOrders() {
        OrderRepository repo = new OrderRepository();
        List<Order> list = repo.list();
        assertEquals(new OrderRepository().list(), list, "La lista no son del mismo tipo");
    }


}