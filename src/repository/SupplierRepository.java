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
import java.util.stream.Collectors;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import comons.IFile;
import comons.SeedData;
import models.Employee;
import models.Supplier;

public class SupplierRepository implements IFile<Supplier> {

    private static final String FilePath= "src/data/data_Supplier.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Supplier> suppliers = new ArrayList<>();



    @Override
    public List<Supplier> load()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Supplier>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Supplier> suppliers)  {
        try {
            mapper.writeValue(new File(FilePath), suppliers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Supplier GetOne (String id) {
        List<Supplier> suppliers = load();
        int supplierID = Integer.parseInt(id);
        Optional<Supplier> results = suppliers.stream()
                .filter(c -> c.getSupplierID() == supplierID).findFirst();
        return results.orElse(null);
    }



    @Override
    public List<Supplier> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Supplier> suppliers = load();
        suppliers.removeIf(c -> c.getSupplierID() == Integer.parseInt(id));
        Save(suppliers);
    }

    @Override
    public void Update(Supplier entity) {
        List<Supplier> suppliers = load();
       //int employeeID = Integer.parseInt(id);
        List<Supplier> updatedSuppliers = suppliers.stream()
                .map(c  -> c.getSupplierID() == entity.getSupplierID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedSuppliers);

    }


}
