package com.example.reactive_rest_mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
IMPORTANT NOTE:

In Order for some of the REACTIVE MONGO OPERATIONS TO WORK - it is necessary to convert the existing collection to a capped collection.

PROCEDURE:
Connect to Mongo Database using Mongo Shell and run command:   db.runCommand( { convertToCapped: COLLECTION_NAME , size: DESIRED_SIZE } ) .

IT IS COMPULSORY TO SPECIFY SIZE IN THE COMMAND.

Only then will the reactive operations work on the tailable cursor.

Reference: https://docs.mongodb.com/manual/core/tailable-cursors/.
 */
@Document(collection = "Employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private long salary;
    private int age;
    private int experience;
    public Employee(String id, String name, long salary, int age, int experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.experience=experience;
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

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }
}
