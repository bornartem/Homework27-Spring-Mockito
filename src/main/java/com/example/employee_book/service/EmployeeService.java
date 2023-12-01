package com.example.employee_book.service;

import com.example.employee_book.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName, int salary, int department);

    List<Employee> getAll();

    Map<String, Employee> getMap();
}
