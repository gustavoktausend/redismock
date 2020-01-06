package com.teste.redismock.redismock.repository;

import com.teste.redismock.redismock.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
