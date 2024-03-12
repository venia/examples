package com.aquila.spring.data.example.basic;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Greg Turnquist
 */
// tag::code[]
public interface EmployeeRepository extends CrudRepository<Employee, Long> { // <1>

}