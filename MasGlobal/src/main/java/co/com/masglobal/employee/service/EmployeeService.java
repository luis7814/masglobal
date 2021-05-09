package co.com.masglobal.employee.service;

import co.com.masglobal.employee.model.Employee;
import co.com.masglobal.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Clase encargada de recibir la información del empleado de la
 * base de datos y organizarla para mostrar al cliente
 * @author Labs
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {


        return employee;
    }


    public Employee update(Employee employee) {

        return employee;
    }

    /**
     * Consulta todos los empleados registrados y calcula su salario anual
     *
     * @return {@link List}
     * @see List
     * @see Employee
     */
    public List<Employee> findAll() {

        return Optional.ofNullable(employeeRepository.findAll())
                .map(value -> {
                    if(value != null) {
                        value.stream()
                            .map(value1 -> {
                                value1.setAnnualSalary(
                                    new SalaryService().calculateHourValue(
                                        value1.getSalary(),
                                        value1.getTypeContract()));
                                            return value1;
                                })
                                .collect(Collectors.toList());
                    }
                    return value;
                }).orElseGet(Collections::emptyList);
    }


    /**
     * Consulta por identificación de empleado y calcula su salario anual
     *
     * @param id id {@link Integer}
     * @return {@link List}
     * @see List
     * @see Employee
     */
    public List<Employee> findById(Integer id) {

        List<Employee> employees = new ArrayList<>();
        employees.add(employeeRepository.findById(id).map(value -> {
                    value.setAnnualSalary(
                            new SalaryService().calculateHourValue(
                                    value.getSalary(),
                                    value.getTypeContract()));
                    return value;
                })
                .orElse(null));

        return employees;
    }

}
