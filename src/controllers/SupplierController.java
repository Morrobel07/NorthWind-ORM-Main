package controllers;

import comons.IFile;
import models.MySupplier;
import repository.SupplierRepository;

import java.util.List;

public class SupplierController {
    private final IFile<MySupplier, Integer> repository;

    public SupplierController(IFile<MySupplier, Integer> repository) {
        this.repository = repository;
    }

    public List<MySupplier> getAllSuppliers() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los proveedores " + e.getMessage());
            return null;
        }
    }

    public MySupplier getSupplierById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los proveedores " + e.getMessage());
            return null;
        }
    }

    public void addSupplier(MySupplier supplier) {
        try {
            List<MySupplier> suppliers = getAllSuppliers();

            for (MySupplier sup : suppliers) {
                if (sup.getSupplierID() == supplier.getSupplierID()) {
                    System.out.println("No puedes realizar un duplicado del id " + supplier.getSupplierID());
                    return;
                }
            }
            repository.addObject(supplier);
            System.out.println("Proveedor agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar proveedor" + e.getMessage());
        }

    }

    public void updateSupplier(MySupplier supplier) {
        try {
            repository.update(supplier);
            System.out.println("Proveedor actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar proveedor" + e.getMessage());
        }
    }

    public void deleteSupplier(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar proveedor" + e.getMessage());
        }
    }

}
