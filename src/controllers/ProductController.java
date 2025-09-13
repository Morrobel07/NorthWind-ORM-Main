package controllers;

import comons.IFile;
import models.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductController {
      private final  IFile<Product> repository ;

      public ProductController(IFile<Product> repository) {
          this.repository = repository;
      }

      public List<Product> getAllProducts() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener todos los productos "+ e.getMessage());
              return null;
          }
      }

      public Product getProductById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener todos los produtos "+ e.getMessage());
              return null;
          }
      }

      public void addProduct(Product product) {
          try {
              List<Product> products =  getAllProducts();

              int newId = products.isEmpty() ?
                      1 : products.stream().
                              mapToInt(e -> e.getProductID()).
                              max().orElse(0) +1;
              product.setProductID(newId);
              products.add(product);
              repository.Save(products);
              System.out.println("Producto agregado correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar producto"+ e.getMessage());
          }

      }

      public void updateProduct(Product product) {
        try {
            repository.Update(product);
            System.out.println("Producto actualizado correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar producto"+ e.getMessage());
        }
      }

      public void deleteProduct(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error al eliminar producto"+ e.getMessage());
          }
      }


}
