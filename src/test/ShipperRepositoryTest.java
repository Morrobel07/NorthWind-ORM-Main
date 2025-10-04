package test;

import models.Shipper;
import org.junit.jupiter.api.Test;
import repository.ShipperRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipperRepositoryTest {
    @Test
    void testListShippers() {
        ShipperRepository repo = new ShipperRepository();
        List<Shipper> list = repo.list();
        assertEquals(new ShipperRepository().list(), list, "La lista no son del mismo tipo");
    }


}