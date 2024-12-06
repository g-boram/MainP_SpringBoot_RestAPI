package com.example.restapi.service;

public class StudentNotFoundException extends Throwable {
    public StudentNotFoundException(String s) {
        System.out.println("s : " + s);
    }
}
