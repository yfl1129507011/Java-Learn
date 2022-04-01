package com.fenlon.pojo;

import lombok.Data;

@Data
public class Blog {
    private int id;
    private String title;
    private String author;
    private int createTime;
    private int views;
}
