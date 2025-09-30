package repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.File;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import comons.IFile;
import models.Categorie;
import models.Employee;
import models.Suppliers;

public class SupplierRepository implements IFile<Suppliers, Integer> {

    private static final String FilePath = "src/data/data_Supplier.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Suppliers> suppliers = new ArrayList<>();

    @Override
    public List<Suppliers> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Suppliers>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist(List<Suppliers> suppliers) {
       mapper.enable(SerializationFeature.INDENT_OUTPUT);
       suppliers.sort((c1, c2) -> c1.getSupplierID().compareTo(c2.getSupplierID()));

        try {
            mapper.writeValue(new File(FilePath), suppliers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addObject(Suppliers entity) {
        List<Suppliers> suppliers = list();

        if (entity.getSupplierID() != null && entity.getSupplierID() != 0) {
            boolean exist = suppliers.stream()
                    .anyMatch(c -> c.getSupplierID().equals(entity.getSupplierID()));
            if (exist)
            {
                System.out.println("Error: ya existe un supplier con ese id" + entity.getSupplierID());
                return;
            }
        }
        int maxId = suppliers.stream()
                .mapToInt(e -> e.getSupplierID())
                .max()
                .orElse(0);
        entity.setSupplierID(maxId + 1);

        suppliers.add(entity);
        persist(suppliers);
        System.out.println("Supplier agregado correctamente.");

    }

    @Override
    public Suppliers findById(Integer id) {
        List<Suppliers> suppliers = list();
        Optional<Suppliers> results = suppliers.stream()
                .filter(c -> c.getSupplierID() == id).findFirst();
        return results.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        List<Suppliers> suppliers = list();
        suppliers.removeIf(c -> c.getSupplierID() == id);
        persist(suppliers);
    }

    @Override
    public void update(Suppliers entity) {
        List<Suppliers> suppliers = list();
        List<Suppliers> updatedSuppliers = suppliers.stream()
                .map(c -> c.getSupplierID() == entity.getSupplierID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedSuppliers);

    }

}
