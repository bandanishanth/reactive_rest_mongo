package com.example.reactive_rest_mongo;

import com.example.reactive_rest_mongo.model.Employee;
import com.example.reactive_rest_mongo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveRestMongoApplication {
    /*Command Line Runner to Initially insert a few records into the collection*/
    @Bean
    CommandLineRunner employees(EmployeeRepository employeeRepository){
        return args -> {
          employeeRepository.deleteAll()
                  .subscribe(null ,null, () -> {

                      Stream.of(new Employee(UUID.randomUUID().toString(),"Peter",2300L, 23,5),
                              new Employee(UUID.randomUUID().toString(),"Sam",1300L, 24,6),
                              new Employee(UUID.randomUUID().toString(),"Ryan",2000L, 25,7),
                              new Employee(UUID.randomUUID().toString(),"Chris",53000L, 26,8)
                      )
                              .forEach(employee -> {
                                 employeeRepository.save(employee)
                                                    .subscribe(System.out::println);
                              });
                  });
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRestMongoApplication.class, args);
    }
}