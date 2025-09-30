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
import models.Categorie;
import models.Employee;
import models.Shipper;

public class ShipperRepository implements IFile<Shipper, Integer> {

    private static final String FilePath = "src/data/data_shipper.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<Employee> employees = new ArrayList<>();

    @Override
    public List<Shipper> list() {
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
    public void persist(List<Shipper> shippers) {
        try {
            mapper.writeValue(new File(FilePath), shippers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addObject(Shipper entity) {
        List<Shipper> shippers = list();

        for (Shipper e : shippers) {
            if (e.getShipperID() == entity.getShipperID()) {
                System.out.println("No puedes realizar un duplicado del id " + entity.getShipperID());
                return;
            }

            shippers.add(entity);
            persist(shippers);
            System.out.println("Empleado agregado correctamente");
        }
    }

    @Override
    public Shipper findById(Integer id) {
        List<Shipper> shippers = list();
        Optional<Shipper> results = shippers.stream()
                .filter(c -> c.getShipperID() == id).findFirst();
        return results.orElse(null);
    }



    @Override
    public void delete(Integer id) {
        List<Shipper> shippers = list();
        shippers.removeIf(c -> c.getShipperID() == id);

        persist(shippers);
    }

    @Override
    public void update(Shipper entity) {
        List<Shipper> shippers = list();
        List<Shipper> updatedShippers = shippers.stream()
                .map(c -> c.getShipperID() == entity.getShipperID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedShippers);

    }

}
