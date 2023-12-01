package com.example.employee_book.serviceImpl;

import com.example.employee_book.model.Employee;
import com.example.employee_book.service.DepartmentService;
import com.example.employee_book.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Employee maxSalaryFromMap(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == (department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee minSalaryFromMap(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == (department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public int sumSalaryFromMap(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == (department))
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public List<Employee> getAll(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == (department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getMap() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
