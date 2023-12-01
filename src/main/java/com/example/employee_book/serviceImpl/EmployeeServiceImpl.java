package com.example.employee_book.serviceImpl;

import com.example.employee_book.model.Employee;
import com.example.employee_book.exception.EmployeeAlreadyAddedException;
import com.example.employee_book.exception.EmployeeNotFoundException;
import com.example.employee_book.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "0", new Employee("Arnold", "Shwarzenegger", 189001, 1),
            "1", new Employee("Silvester", "Stallone", 189002, 2),
            "2", new Employee("Bruce", "Lee", 189003, 1),
            "3", new Employee("Steven", "Segal", 189004, 2),
            "4", new Employee("Chuck", "Norris", 189005, 1),
            "5", new Employee("Bruce", "Willis", 189006, 2)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }
}
