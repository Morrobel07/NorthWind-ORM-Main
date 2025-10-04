package repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.stream.Collectors;

import comons.IFile;
import models.Employee;

public class EmployeeRepository implements IFile<Employee,Integer> {

    private static final String FilePath= "src/data/data_Employee.json";
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    /**
     * Carga la lista de empleados desde un archivo JSON.
     * @return Una lista de objetos Employee. Si el archivo no existe o está vacío, devuelve una lista vacía.
     */
    @Override
    public List<Employee> list()    {
        try{
            File file = new File(FilePath);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }



    @Override
    public void persist(List<Employee> employees )  {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        employees.sort((c1, c2) -> c1.getEmployeeID().compareTo( c2.getEmployeeID()));
        try {
            mapper.writeValue(new File(FilePath), employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void addObject(Employee entity){
       List<Employee> employees = list();
       if (entity.getEmployeeID() != null && entity.getEmployeeID() != 0 ) {
           boolean exist = employees.stream()
                   .anyMatch(c -> c.getEmployeeID().equals(entity.getEmployeeID()));
           if (exist) {
               System.out.println("Error: ya existe un empleado con ese id" + entity.getEmployeeID());
               return;
           }
       }

           int maxId = employees.stream()
                   .mapToInt(e -> e.getEmployeeID())
                   .max()
                   .orElse(0);

           entity.setEmployeeID(maxId + 1);

           employees.add(entity);
           persist(employees);
           System.out.println("Empleado agregado correctamente.");

       }





    /**
     * Busca y devuelve un único empleado por su ID.
     * @param id El ID del empleado a buscar (en formato String).
     * @return Un objeto Employee si se encuentra, o null si no existe un empleado con ese ID.
     */

    @Override
    public Employee findById (Integer id) {

        List<Employee> employees = list();
        Optional<Employee> results = employees.stream()
                .filter(c -> c.getEmployeeID() == id).findFirst();
        return results.orElse(null);
    }



    //@Override
    //public List<Employee> GetAll() {
     //   return load();
    //}

    @Override
    public void delete(Integer id) {
        List<Employee> employees = list();
        employees.removeIf(c -> c.getEmployeeID() == id);
        persist(employees);
    }

    @Override
    public void update(Employee entity) {
        List<Employee> employees = list();
        List<Employee> updatedEmployees = employees.stream()
                .map(c  -> c.getEmployeeID() == entity.getEmployeeID() ? entity : c)
                .collect(Collectors.toList());
        persist(updatedEmployees);


    }


}
