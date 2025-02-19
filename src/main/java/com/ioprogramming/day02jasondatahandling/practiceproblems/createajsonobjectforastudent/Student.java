package com.ioprogramming.day02jasondatahandling.practiceproblems.createajsonobjectforastudent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public static void main(String[] args) {
        try {
            List<String> list= Arrays.asList("Mathematics", "Physics", "Computer Science");
            Student student = new Student("Aakrati", 21, list);
            System.out.println(student.toJson());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
