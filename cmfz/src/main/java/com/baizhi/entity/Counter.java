package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Counter {
    private int id;
    private String title;
    private int count;
    private int course_id;
    private int user_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
