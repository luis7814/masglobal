DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id NUMBER(20)  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  salary NUMBER(20) NOT NULL,
  type_contract VARCHAR(20) NOT NULL,
  annual_salary NUMBER(20) NOT NULL
);

INSERT INTO employees (id, first_name, last_name, salary, type_contract, annual_salary) VALUES
  (1, 'Juan', 'Dangote', 40000, 'Hour', 0),
  (2, 'Pedro', 'Coral', 7500000, 'Month', 0),
  (3, 'Juana', 'Perez', 45000, 'Hour', 0),
  (4, 'Jose', 'Guillen', 8500000, 'Month', 0),
  (5, 'Carmela', 'Escobar', 50000, 'Hour', 0),
  (6, 'Antonio', 'Ruiz', 7000000, 'Month', 0);