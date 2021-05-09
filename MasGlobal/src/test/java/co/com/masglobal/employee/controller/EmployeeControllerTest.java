package co.com.masglobal.employee.controller;

import co.com.masglobal.employee.model.Employee;
import co.com.masglobal.employee.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {


    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private Employee employee;
    private List<Employee> employees;

    @Before
    public void setUp() {

        employee = new Employee();
        employee.setAnnualSalary(10000);
        employee.setSalary(5000);
        employee.setFirstName("Juan");
        employee.setLastName("Gomez");
        employee.setTypeContract("Hour");
        employee.setId(1);

        employees = new ArrayList<>();
        employees.add(employee);


    }

    @Test
    public void findAllTest() {

        when(employeeService.findAll()).thenReturn(employees);
        ResponseEntity<List<Employee>> response = employeeController.findAll();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());


    }

    @Test
    public void findByIdTest() {

        when(employeeService.findAll()).thenReturn(employees);
        ResponseEntity<List<Employee>> response = employeeController.findById(1);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());


    }

}
