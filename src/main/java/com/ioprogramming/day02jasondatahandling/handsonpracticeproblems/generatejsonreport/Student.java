package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.generatejsonreport;

public class Student {
    String name;
    int age;
    String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}
