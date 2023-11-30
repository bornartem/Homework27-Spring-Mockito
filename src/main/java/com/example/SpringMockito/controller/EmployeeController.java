package com.example.SpringMockito.controller;

import com.example.SpringMockito.Employee;
import com.example.SpringMockito.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int department){
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int department){
        return employeeService.removeEmployee(firstName, lastName, salary, department);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int salary,
                                   @RequestParam int department){
        return employeeService.findEmployee(firstName, lastName, salary, department);
    }
@GetMapping
    public Collection<Employee>getAll(){
        return employeeService.getAll();
}
}
