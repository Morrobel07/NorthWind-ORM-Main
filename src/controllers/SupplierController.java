package controllers;

import comons.IFile;
import models.MySupplier;
import repository.SupplierRepository;

import java.util.List;

public class SupplierController {
    private final IFile<MySupplier> repository;

    public SupplierController(IFile<MySupplier> repository) {
        this.repository = repository;
    }

    public List<MySupplier> getAllSuppliers() {
        try {
            return repository.GetAll();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los proveedores " + e.getMessage());
            return null;
        }
    }

    public MySupplier getSupplierById(String id) {
        try {
            return repository.GetOne(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los proveedores " + e.getMessage());
            return null;
        }
    }

    public void addSupplier(MySupplier supplier) {
        try {
            List<MySupplier> suppliers = getAllSuppliers();
            suppliers.add(supplier);
            repository.Save(suppliers);
            System.out.println("Proveedor agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar proveedor" + e.getMessage());
        }

    }

    public void updateSupplier(MySupplier supplier) {
        try {
            repository.Update(supplier);
            System.out.println("Proveedor actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar proveedor" + e.getMessage());
        }
    }

    public void deleteSupplier(String id) {
        try {
            repository.Delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar proveedor" + e.getMessage());
        }
    }

}
