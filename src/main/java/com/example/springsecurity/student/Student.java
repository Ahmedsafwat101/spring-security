package com.example.springsecurity.student;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private Integer stdId;
    private String stdName;
}
