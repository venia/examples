package com.aquila.spring.data.example.basic;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> { // <1>

}