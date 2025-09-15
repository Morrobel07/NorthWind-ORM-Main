package controllers;

import comons.IFile;
import models.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IFile<Employee> repository;

    public EmployeeController(IFile<Employee> repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista completa de todos los empleados.
     * 
     * @return Una lista de objetos Employee, o null si ocurre un error.
     */
    public List<Employee> getAllEmployees() {
        try {
            return repository.GetAll();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los empleados " + e.getMessage());
            return null;
        }
    }

    /**
     * Busca y devuelve un empleado específico por su ID.
     * 
     * @param id El ID del empleado a buscar.
     * @return El objeto Employee si se encuentra, o null si no existe o si ocurre
     *         un error.
     */
    public Employee getEmployeeById(String id) {
        try {
            return repository.GetOne(id);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los empleados " + e.getMessage());
            return null;
        }
    }

    /**
     * Agrega un nuevo empleado al repositorio.
     * 
     * @param employee El objeto Employee a agregar.
     */
    public void addEmployee(Employee employee) {
        try {
            List<Employee> employees = getAllEmployees();

            int newId = employees.isEmpty() ? 1
                    : employees.stream().mapToInt(e -> e.getEmployeeID()).max().orElse(0) + 1;
            employee.setEmployeeID(newId);
            employees.add(employee);
            repository.Save(employees);
            System.out.println("Empleado agregado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar empleado" + e.getMessage());
        }

    }

    /**
     * Actualiza la información de un empleado existente.
     * 
     * @param employee El objeto Employee con los datos actualizados.
     */
    public void updateEmployee(Employee employee) {
        try {
            repository.Update(employee);
            System.out.println("Empleado actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar empleado" + e.getMessage());
        }
    }

    /**
     * Elimina un empleado del repositorio usando su ID.
     * 
     * @param id El ID del empleado a eliminar.
     */
    public void deleteEmployee(String id) {
        try {
            repository.Delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar empleado" + e.getMessage());
        }
    }

}
