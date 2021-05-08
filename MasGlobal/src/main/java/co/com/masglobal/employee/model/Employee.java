package co.com.masglobal.employee.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "type_contract")
    private String typeContract;

    private Integer annualSalary;


}
