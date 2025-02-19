package com.ioprogramming.day02jasondatahandling.practiceproblems.convertlisttojasonarray;

import java.util.Arrays;
import java.util.List;

public class ConvertListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Car> carList = Arrays.asList(
                    new Car("Toyota", "Camry", 2022),
                    new Car("Honda", "Civic", 2023),
                    new Car("Ford", "Mustang", 2021)
            );

            String jsonArray = Car.convertToJson(carList);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

