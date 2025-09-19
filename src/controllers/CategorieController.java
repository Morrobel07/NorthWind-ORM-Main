package controllers;

import comons.IFile;
import models.Categorie;
import repository.CategorieRepository;

import java.util.List;

public class CategorieController {
    private final IFile<Categorie,Integer> repository;

    public CategorieController(IFile<Categorie,Integer> repository) {
        this.repository = repository;
    }

    public List<Categorie> getAllCategories() {
        try {
            return repository.list();
        } catch (Exception e) {
            System.out.println("Error al obtener todas las categorias " + e.getMessage());
            return null;
        }
    }

    public Categorie getCategorieById(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las categoria " + e.getMessage());
            return null;
        }
    }

    public void addCategorie(Categorie categorie) {
        try {

            List<Categorie> categories = getAllCategories();

            for (Categorie c : categories){
                if(c.getCategoryID() == categorie.getCategoryID()){
                    System.out.println("No puedes realizar un duplicado del id " + categorie.getCategoryID());
                    return;
                }

            }
            repository.addObject(categorie);
            System.out.println("Categoria agregada correctamente");


        } catch (Exception e) {
            System.out.println("Error al agregar categoria" + e.getMessage());
        }

    }

    public void updateCategorie(Categorie categorie) {
        try {
            repository.update(categorie);
            System.out.println("Categoria actualizada correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar categoria" + e.getMessage());
        }
    }

    public void deleteCategorie(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar Categoria" + e.getMessage());
        }
    }

}
