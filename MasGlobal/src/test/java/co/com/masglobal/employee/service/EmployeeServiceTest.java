package co.com.masglobal.employee.service;

import co.com.masglobal.employee.model.Employee;
import co.com.masglobal.employee.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

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
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> response = employeeService.findAll();
        Assert.assertNotNull(response);
    }

    @Test
    public void findAllTestIsNull() {
        when(employeeRepository.findAll()).thenReturn(null);
        List<Employee> response = employeeService.findAll();
        Assert.assertNotNull(response);
        Assert.assertEquals(0, response.size());
    }


    @Test
    public void findByIdTest() {
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(employee));
        List<Employee> response = employeeService.findById(1);
        Assert.assertNotNull(response);
    }

    @Test
    public void findByIdTestIsNull() {
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));
        List<Employee> response = employeeService.findById(1);
        Assert.assertNotNull(response);
    }

}
