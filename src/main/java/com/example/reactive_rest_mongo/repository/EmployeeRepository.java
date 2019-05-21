package com.example.reactive_rest_mongo.repository;

import com.example.reactive_rest_mongo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

}
