package controllers;

import comons.IFile;
import models.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeController {
      private final IFile<Employee> repository ;

      public EmployeeController(IFile<Employee> repository) {
          this.repository = repository;
      }

      public List<Employee> getAllEmployees() {
          try{
              return repository.GetAll();
          }catch (Exception e){
              System.out.println( "Error al obtener todos los empleados "+ e.getMessage());
              return null;
          }
      }

      public Employee getEmployeeById(String id) {
          try {
              return repository.GetOne(id);
          } catch (Exception e) {
              System.out.println( "Error al obtener todos los empleados "+ e.getMessage());
              return null;
          }
      }

      public void addEmployee(Employee employee) {
          try {
              List<Employee> employees =  getAllEmployees();
              employees.add(employee);
              repository.Save(employees);
              System.out.println("Empleado agregado correctamente");
           } catch (Exception e) {
              System.out.println( "Error al agregar empleado"+ e.getMessage());
          }

      }

      public void updateEmployee(Employee employee) {
        try {
            repository.Update(employee);
            System.out.println("Empleado actualizado correctamente");
        }catch (Exception e) {
            System.out.println( "Error al actualizar empleado"+ e.getMessage());
        }
      }

      public void deleteEmployee(String id) {
          try {
              repository.Delete(id);
          }catch (Exception e) {
              System.out.println( "Error al eliminar empleado"+ e.getMessage());
          }
      }


}
