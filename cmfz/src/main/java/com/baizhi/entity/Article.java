package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String title;
    private String content;
    private String insertimgPath;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

}
