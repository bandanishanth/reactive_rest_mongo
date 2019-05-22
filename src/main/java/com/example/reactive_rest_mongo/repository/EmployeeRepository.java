package com.example.reactive_rest_mongo.repository;

import com.example.reactive_rest_mongo.model.Employee;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {
    @Tailable /*Annotation used as a Tail Cursor to Mongo*/
    Flux<Employee> findByNameEqualsAndAgeEquals(String empName, int empAge);
}
