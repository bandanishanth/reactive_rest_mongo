package com.example.reactive_rest_mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private long salary;

    public Employee(String id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee()
    {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
