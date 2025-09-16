package controllers;

import comons.IFile;
import models.Employee;
import models.Shipper;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IFile<Employee,Integer> repository;

    public EmployeeController(IFile<Employee,Integer> repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista completa de todos los empleados.
     * 
     * @return Una lista de objetos Employee, o null si ocurre un error.
     */
    public List<Employee> getAllEmployees() {
        try {
            return repository.list();
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
    public Employee getEmployeeById(Integer id) {
        try {
            return repository.findById(id);
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
            for (Employee e : employees) {
                if (e.getEmployeeID() == employee.getEmployeeID()) {
                    System.out.println("No puedes realizar un duplicado del id " + employee.getEmployeeID());
                    return;
                }
                repository.add(employee);
                System.out.println("Empleado agregado correctamente");

            }
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
            repository.update(employee);
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
    public void deleteEmployee(Integer id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar empleado" + e.getMessage());
        }
    }

}
