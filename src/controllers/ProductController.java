package controllers;

import comons.IFile;
import models.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductController {
    private final IFile<Product, Integer> repository;

    public ProductController(IFile<Product, Integer> repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los productos " + e.getMessage());
            return null;
        }
    }

    public Product getProductById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los produtos " + e.getMessage());
            return null;
        }
    }

    public void addProduct(Product product) {
        try {
            List<Product> products = getAllProducts();
            for (Product p : products) {
                if (p.getProductID() == product.getProductID()) {
                    System.out.println("No puedes realizar un duplicado del id " + product.getProductID());
                    return;
                }
            }
            products.add(product);
            System.out.println("Producto agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar producto" + e.getMessage());
        }

    }

    public void updateProduct(Product product) {
        try {
            repository.update(product);
            System.out.println("Producto actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar producto" + e.getMessage());
        }
    }

    public void deleteProduct(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar producto" + e.getMessage());
        }
    }

}
