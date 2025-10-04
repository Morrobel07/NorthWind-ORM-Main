package test;

import controllers.EmployeeController;
import models.Employee;
import org.junit.jupiter.api.Test;
import repository.EmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    @Test
    void testListEmployees() {
        EmployeeRepository repo = new EmployeeRepository();
        List<Employee> list = repo.list();
        assertEquals(new EmployeeController(new EmployeeRepository()).getAllEmployees(), list, "La lista no son del mismo tipo");
    }


}