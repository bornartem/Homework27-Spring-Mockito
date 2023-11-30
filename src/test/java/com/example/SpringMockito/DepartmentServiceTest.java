package com.example.SpringMockito;

import com.example.SpringMockito.service.DepartmentServiceImpl;
import com.example.SpringMockito.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Artem", "Bornyakov", 200022, 2),
            new Employee("Corey", "Taylor", 200011, 1),
            new Employee("Artem", "Born", 200033, 2),
            new Employee("Artem", "BR", 200044, 1)
    ));

    @Test
    public void shouldReturnSumOfSalaries() {
        when(employeeServiceMock.getAll())
                .thenReturn(employee);
        int sumSalaries = out.sumSalaryFromMap(1);
        assertEquals(400055, sumSalaries);

    }

    @Test
    public void shouldReturnMaxSalary() {
        when(employeeServiceMock.getAll())
                .thenReturn(employee);
        Employee maxSalaries = out.maxSalaryFromMap(1);
        assertEquals(employee.get(3), maxSalaries);
    }

    @Test
    public void shouldReturnMinSalary() {
        when(employeeServiceMock.getAll())
                .thenReturn(employee);
        Employee minSalaries = out.minSalaryFromMap(1);
        assertEquals(employee.get(1), minSalaries);
    }

    @Test
    public void shouldReturnEmployeeListByDepartment() {
        when(employeeServiceMock.getAll())
                .thenReturn(employee);
        List<Employee> result = out.getAll(1);
        assertTrue(employee.containsAll(result));
    }

    @Test
    public void shouldReturnExceptionWhenEmptyEmployeesList() {
        when(employeeServiceMock.getAll())
                .thenReturn(Collections.emptyList());
        assertThrows(NoSuchElementException.class,
                () -> out.maxSalaryFromMap(1));

    }

    @Test
    public void shouldReturnExceptionWhenCallMinSalaryMethodAndEmptyEmployeesList() {
        when(employeeServiceMock.getAll())
                .thenReturn(Collections.emptyList());
        assertThrows(NoSuchElementException.class,
                () -> out.minSalaryFromMap(1));
    }

    @Test
    public void shouldReturnEmptyListByDepartment() {
        when(employeeServiceMock.getAll())
                .thenReturn(Collections.emptyList());
        List<Employee> result = new ArrayList<>(Collections.emptyList());
        assertEquals(out.getAll(1), result);
    }
}
