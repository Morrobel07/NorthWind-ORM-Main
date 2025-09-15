package controllers;

import comons.IFile;
import models.Shipper;
import repository.ShipperRepository;

import java.util.List;

public class ShipperController {
    private final IFile<Shipper> repository;

    public ShipperController(IFile<Shipper> repository) {
        this.repository = repository;
    }

    public List<Shipper> getAllShippers() {
        try {
            return repository.GetAll();
        } catch (Exception e) {
            System.out.println("Error al obtener el shipping " + e.getMessage());
            return null;
        }
    }

    public Shipper getShipperById(String id) {
        try {
            return repository.GetOne(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los shipping " + e.getMessage());
            return null;
        }
    }

    public void addShipper(Shipper shipper) {
        try {

            List<Shipper> shippers = getAllShippers();
            // Implementación para evitar duplicados
            for (Shipper e : shippers) {
                if (e.getShipperID() == shipper.getShipperID()) {
                    System.out.println("No puedes realizar un duplicado del id " + shipper.getShipperID());
                    return;
                }
            }
            shippers.add(shipper);
            // int newId = shippers.isEmpty() ? 1 : shippers.stream().mapToInt(e ->
            // e.getShipperID()).max().orElse(0) + 1;
            // shipper.setShipperID(newId);

            repository.Save(shippers);
            System.out.println("Shipping agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar shipping" + e.getMessage());
        }

    }

    public void updateShipper(Shipper shipper) {
        try {
            repository.Update(shipper);
            System.out.println("Shipping actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar shipping" + e.getMessage());
        }
    }

    public void deleteShipper(String id) {
        try {
            repository.Delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar shipping" + e.getMessage());
        }
    }

}
