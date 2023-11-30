package com.example.SpringMockito.controller;

import com.example.SpringMockito.Employee;
import com.example.SpringMockito.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}/salary/max")
    public Employee maxSalaryFromMap(@PathVariable int id) {
        return departmentService.maxSalaryFromMap(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee minSalaryFromMap(@PathVariable int id) {
        return departmentService.minSalaryFromMap(id);
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int department) {
        return departmentService.sumSalaryFromMap(department);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllFromList(@PathVariable int id) {
        return departmentService.getAll(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllFromMap() {
        return departmentService.getMap();
    }

}
