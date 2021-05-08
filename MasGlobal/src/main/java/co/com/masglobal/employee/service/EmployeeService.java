package co.com.masglobal.employee.service;

import co.com.masglobal.employee.model.Employee;
import co.com.masglobal.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
     * @return La lista de empleados con su valor anual.
     * @since 1.0
     */
    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(value -> {
                    value.setAnnualSalary(
                            new SalaryService().calculateHourValue(
                                    value.getSalary(),
                                    value.getTypeContract()));

                    return value;
                })
                .collect(Collectors.toList());
    }


    /**
     * @param id del empleado a retornar
     * @return la información del empleado consultado por id
     * @since 1.0
     */
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).map(value -> {
                    value.setAnnualSalary(
                            new SalaryService().calculateHourValue(
                                    value.getSalary(),
                                    value.getTypeContract()));
                    return value;
                })
                .orElse(null);
    }

}
