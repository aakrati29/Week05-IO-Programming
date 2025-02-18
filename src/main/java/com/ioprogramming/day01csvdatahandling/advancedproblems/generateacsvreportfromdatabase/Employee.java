package com.ioprogramming.day01csvdatahandling.advancedproblems.generateacsvreportfromdatabase;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toCSVString() {
        return id + "," + name + "," + department + "," + salary;
    }
}
