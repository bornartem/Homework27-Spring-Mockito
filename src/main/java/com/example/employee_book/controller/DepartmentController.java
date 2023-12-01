package com.example.employee_book.controller;

import com.example.employee_book.model.Employee;
import com.example.employee_book.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/max")
    public Employee maxSalaryFromMap(@PathVariable Integer id) {
        return departmentService.maxSalaryFromMap(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee minSalaryFromMap(@PathVariable Integer id) {
        return departmentService.minSalaryFromMap(id);
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int department) {
        return departmentService.sumSalaryFromMap(department);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllFromList(@PathVariable Integer id) {
        return departmentService.getAll(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllFromMap() {
        return departmentService.getMap();
    }

}
