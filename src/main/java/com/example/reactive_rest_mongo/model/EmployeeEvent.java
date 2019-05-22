package com.example.reactive_rest_mongo.model;

import java.util.Date;

/*
* EmployeeEvent = Employee + Date
*
* This Class is used to demonstrsate the reactive nature of This application.
*
* We use this class in:
* 1)/{id}/events
* 2)/findByNameAndAge/{name}/{age}
*
* */
public class EmployeeEvent {

    private Employee employee;
    private Date date;

    public EmployeeEvent(Employee employee, Date date) {
        this.employee = employee;
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
