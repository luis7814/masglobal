package co.com.masglobal.employee.controller;

import co.com.masglobal.employee.model.Employee;
import co.com.masglobal.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase encargada de exponer la información del empleado
 * por medio de servicios REST
 * @author Labs
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Api(tags = "Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> save(Employee employee) {

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }


    @PutMapping("/employee")
    public ResponseEntity<Employee> update(Employee employee) {

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }


    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAll() {

        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.ACCEPTED);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {

        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.ACCEPTED);
    }

}
