package com.course.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  int id;
    private String name;
    private Double score;
    private Date birthday;
}
