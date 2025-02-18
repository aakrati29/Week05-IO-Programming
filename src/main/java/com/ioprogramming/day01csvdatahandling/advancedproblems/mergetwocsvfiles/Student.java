package com.ioprogramming.day01csvdatahandling.advancedproblems.mergetwocsvfiles;

class Student {
    int id;
    String name;
    int age;
    double marks;
    String grade;

    public Student(int id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}
