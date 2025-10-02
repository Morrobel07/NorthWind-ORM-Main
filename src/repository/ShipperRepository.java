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

    @Override
    public List<Shipper> list() {
        try {
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Shipper>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void persist(List<Shipper> shippers) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        shippers.sort((c1, c2) -> c1.getShipperID().compareTo(c2.getShipperID()));
        try {
            mapper.writeValue(new File(FilePath), shippers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addObject(Shipper entity) {
        List<Shipper> shippers = list();

        if (entity.getShipperID() != null && entity.getShipperID() != 0) {
            boolean exist = shippers.stream()
                    .anyMatch(c -> c.getShipperID().equals(entity.getShipperID()));
            if (exist) {
                System.out.println("Error: ya exixste un envio con ese id" + entity.getShipperID());
                return;
            }
        }
        int maxId = shippers.stream()
                .mapToInt(e -> e.getShipperID())
                .max()
                .orElse(0);
        entity.setShipperID(maxId + 1);

        shippers.add(entity);
        persist(shippers);
        System.out.println("Envio agregado correctamente.");

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
