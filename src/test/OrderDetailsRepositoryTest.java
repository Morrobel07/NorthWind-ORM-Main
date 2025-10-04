package test;

import models.OrderDetails;
import org.junit.jupiter.api.Test;
import repository.OrderDetailsRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailsRepositoryTest {
    @Test
    void testListOrderDetails() {
        OrderDetailsRepository repo = new OrderDetailsRepository();
        List<OrderDetails> list = repo.list();
        assertEquals(new OrderDetailsRepository().list(), list, "La lista no son del mismo tipo");

    }

}