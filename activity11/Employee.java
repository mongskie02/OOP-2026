package com.gson.model;

import java.util.*;

public abstract class Employee {
    private String name;
    private String employeeId;
    protected EmployeeType type;

    public Employee(String name, String employeeId, EmployeeType type) {
        this.name = name;
        this.employeeId = employeeId;
        this.type = type;
    }

    public abstract double calculateEarnings();

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId + ", Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    
}