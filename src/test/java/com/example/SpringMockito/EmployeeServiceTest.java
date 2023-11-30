package com.example.SpringMockito;

import com.example.SpringMockito.exception.EmployeeAlreadyAddedException;
import com.example.SpringMockito.exception.EmployeeNotFoundException;
import com.example.SpringMockito.service.EmployeeService;
import com.example.SpringMockito.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService out = new EmployeeServiceImpl();
    Employee employee = new Employee("Artem", "Bornyakov", 200022, 2);
    Employee employee1 = new Employee("Corey", "Taylor", 200011, 1);

    @Test
    public void shouldAddEmployeeToMap() {
        Employee result = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        assertTrue(out.getMap().containsValue(result));
        assertEquals(employee, result);
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenSuchEmployeeContains() {
        Employee result = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()));
    }

    @Test
    public void shouldRemoveEmployeeToMap() {
        Employee result = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        out.removeEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        assertFalse(out.getMap().containsValue(result));
        assertEquals(employee, result);
    }

    @Test
    public void shouldFindEmployeeIntoMap() {
        Employee result = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        out.findEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        assertTrue(out.getMap().containsValue(result));
        assertEquals(employee, result);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeNotFound() {
        Employee result = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        out.removeEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployeeAndHeIsAbsent() {
        Employee result = out.addEmployee(null, null, 0, 0);
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()));
    }

    @Test
    public void shouldReturnEmployeeList() {
        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        out.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        Collection<Employee> result = out.getAll();
        assertTrue(result.containsAll(List.of(employee, employee1)));
    }

    @Test
    public void shouldReturnEmployeeMap() {
        Map<String, Employee> all = out.getMap();
        assertFalse(all.isEmpty());
    }
}
