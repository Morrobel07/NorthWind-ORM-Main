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
import models.Shipper;

public class ShipperRepository implements IFile<Shipper> {

    private static final String FilePath = "src/data/data_shipper.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Employee> employees = new ArrayList<>();
    private SeedData seed;

    @Override
    public List<Shipper> load() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Shipper>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void Save(List<Shipper> shippers) {
        try {
            mapper.writeValue(new File(FilePath), shippers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Shipper GetOne(String id) {
        List<Shipper> shippers = load();
        int shipperID = Integer.parseInt(id);
        Optional<Shipper> results = shippers.stream()
                .filter(c -> c.getShipperID() == shipperID).findFirst();
        return results.orElse(null);
    }

    @Override
    public List<Shipper> GetAll() {
        return load();
    }

    @Override
    public void Delete(String id) {
        List<Shipper> shippers = load();
        shippers.removeIf(c -> c.getShipperID() == Integer.parseInt(id));

        Save(shippers);
    }

    @Override
    public void Update(Shipper entity) {
        List<Shipper> shippers = load();
        // int employeeID = Integer.parseInt(id);
        List<Shipper> updatedShippers = shippers.stream()
                .map(c -> c.getShipperID() == entity.getShipperID() ? entity : c)
                .collect(Collectors.toList());
        Save(updatedShippers);

    }

}
