package com.example.reactive_rest_mongo.resource;

import com.example.reactive_rest_mongo.model.Employee;
import com.example.reactive_rest_mongo.model.EmployeeEvent;
import com.example.reactive_rest_mongo.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeResource {

    private EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Flux<Employee> getAll()
    {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<Employee> getId(@PathVariable("id") final String empId)
    {
        return employeeRepository.findById(empId);
    }

    @GetMapping(value = "{id}/events" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String empId)
    {
        return employeeRepository.findById(empId)
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));

                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate( ()-> new EmployeeEvent(employee,new Date()))
                    );

                    return Flux.zip(interval,employeeEventFlux)
                            .map(Tuple2::getT2);
                });
    }

    /*
    NOTE:

    Rule:
    Case -1) Conversion of same type i.e Flux<Class-1> to Flux<Class2> needs only 'flatMap'
    Case -2) Conversion from Mono<Class-1> to Flux<Class-2> requires 'flatMapMany'. (One to Many Conversion).

    Example:
    Case1:
    'findByNameAndAge' method in EmployeeRepository class returns : Flux<Employee>
    We convert that flux to Flux<EmployeeEvent> using flatMap. Since we are converting Flux to Flux we only need 'flatMap'.

    In the above example we findById returns a Mono<Employee>. To convert it into Flux<EmployeeEven> we use flatMapMany.
     */
    @GetMapping(value = "findByNameAndAge/{name}/{age}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getByNameAndAge(@PathVariable("age") final int empAge, @PathVariable("name") String empName)
    {
        return employeeRepository.findByNameEqualsAndAgeEquals(empName,empAge)
                .flatMap(employee ->{
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate( ()-> new EmployeeEvent(employee,new Date()))
                    );
                    return employeeEventFlux;
                });
    }

    @GetMapping(value="/hello")
    public String message()
    {
        return "Hello!, Spring";
    }
}