package com.fenlon.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private Teacher teacher;
    private String name;
}
