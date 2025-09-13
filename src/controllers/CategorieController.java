package controllers;

import comons.IFile;
import models.Categorie;
import repository.CategorieRepository;

import java.util.List;

public class CategorieController {
      private final  IFile<Categorie> repository ;

      public CategorieController(IFile<Categorie> repository) {
          this.repository = repository;
      }

      public List<Categorie> getAllCategories() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener todas las categorias "+ e.getMessage());
              return null;
          }
      }

      public Categorie getCategorieById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener todas las categoria "+ e.getMessage());
              return null;
          }
      }

      public void addCategorie(Categorie categorie) {
          try {

              List<Categorie> categories =  getAllCategories();

              int newId = categories.isEmpty() ? 1 :
                      categories.stream().
                              mapToInt(e -> e.getCategoryID()).
                              max().orElse(0) +1;

              categorie.setCategoryID(newId);
              categories.add(categorie);
              repository.Save(categories);
              System.out.println("Categoria agregada correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar categoria"+ e.getMessage());
          }

      }

      public void updateCategorie(Categorie categorie) {
        try {
            repository.Update(categorie);
            System.out.println("Categoria actualizada correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar categoria"+ e.getMessage());
        }
      }

      public void deleteCategorie(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error al eliminar Categoria"+ e.getMessage());
          }
      }


}
