package controllers;

import comons.IFile;
import models.Shipper;
import repository.ShipperRepository;

import java.util.List;

public class ShipperController {
    private final IFile<Shipper,Integer> repository;

    public ShipperController(IFile<Shipper,Integer> repository) {
        this.repository = repository;
    }

    public List<Shipper> getAllShippers() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener el shipping " + e.getMessage());
            return null;
        }
    }

    public Shipper getShipperById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los shipping " + e.getMessage());
            return null;
        }
    }

    public void addShipper(Shipper shipper) {
        try {

            List<Shipper> shippers = getAllShippers();

            for (Shipper e : shippers) {
                if (e.getShipperID() == shipper.getShipperID()) {
                    System.out.println("No puedes realizar un duplicado del id " + shipper.getShipperID());
                    return;
                }
            }
            repository.addObject(shipper);
            System.out.println("Shipping agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar shipping" + e.getMessage());
        }

    }

    public void updateShipper(Shipper shipper) {
        try {
            repository.update(shipper);
            System.out.println("Shipping actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar shipping" + e.getMessage());
        }
    }

    public void deleteShipper(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar shipping" + e.getMessage());
        }
    }

}
