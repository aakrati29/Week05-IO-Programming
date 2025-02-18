package com.ioprogramming.day01csvdatahandling.basicproblems.readcsvfileandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentsDetails {
    public static void readCSVFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\basicproblems\\readcsvfileandprintdata\\Data.csv"))){
            String line;
            while((line= br.readLine()) != null){
                String[] column = line.split(",");
                System.out.println(column[0]+ " " + column[1] + " " + column[2] + " " + column[3]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        readCSVFile();
    }
}
