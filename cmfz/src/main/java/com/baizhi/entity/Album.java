package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Album {
    private int id;
    private String title;
    private String coveImg;
    private int count;
    private int score;
    private String author;
    private String broadCast;
    private String brief;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private List<Chapter> children;
}
