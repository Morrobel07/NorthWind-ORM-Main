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
import comons.SeedData;
import models.Categorie;
import models.Employee;
import models.MySupplier;

public class SupplierRepository implements IFile<MySupplier,Integer> {

    private static final String FilePath = "src/data/data_Supplier.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<MySupplier> suppliers = new ArrayList<>();

    @Override
    public List<MySupplier> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<MySupplier>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }



    @Override
    public void persist(List<MySupplier> suppliers) {
        try {
            mapper.writeValue(new File(FilePath), suppliers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(MySupplier entity) {
        List<MySupplier> suppliers = list();

        for (MySupplier e : suppliers) {
            if (e.getSupplierID() == entity.getSupplierID()) {
                System.out.println("No puedes realizar un duplicado del id " + entity.getSupplierID());
                return;
            }

            suppliers.add(entity);
            persist(suppliers);
            System.out.println("Empleado agregado correctamente");
        }
    }

    @Override
    public MySupplier findById(Integer id) {
        List<MySupplier> suppliers = list();
        Optional<MySupplier> results = suppliers.stream()
                .filter(c -> c.getSupplierID() == id).findFirst();
        return results.orElse(null);
    }



    @Override
    public void delete(Integer id) {
        List<MySupplier> suppliers = list();
        suppliers.removeIf(c -> c.getSupplierID() == id);
        persist(suppliers);
    }

    @Override
    public void update(MySupplier entity) {
        List<MySupplier> suppliers = list();
        List<MySupplier> updatedSuppliers = suppliers.stream()
                .map(c -> c.getSupplierID() == entity.getSupplierID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedSuppliers);

    }

}
