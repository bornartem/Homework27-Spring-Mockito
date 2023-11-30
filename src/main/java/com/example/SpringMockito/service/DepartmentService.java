package com.example.SpringMockito.service;

import com.example.SpringMockito.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalaryFromMap(int department);

    Employee minSalaryFromMap(int department);

    int sumSalaryFromMap(int department);

    List<Employee> getAll(int department);

    Map<Integer, List<Employee>> getMap();
}
