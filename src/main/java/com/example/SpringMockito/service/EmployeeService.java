package com.example.SpringMockito.service;

import com.example.SpringMockito.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName, int salary, int department);

    Collection<Employee> getAll();

    Map<String, Employee> getMap();
}
