package com.ioprogramming.day01csvdatahandling.advancedproblems.encryptanddecryptcsvdata;

public class Employee {
    String id;
    String name;
    String email;
    String salary;

    public Employee(String id, String name, String email, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', email='" + email + "', salary='" + salary + "'}";
    }

    public String toCSVString() {
        return id + "," + name + "," + email + "," + salary;
    }

    public static Employee fromCSVString(String csv) {
        String[] fields = csv.split(",");
        return new Employee(fields[0], fields[1], fields[2], fields[3]);
    }
}
