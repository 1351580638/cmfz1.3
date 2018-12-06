package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Showw {
    private int id;
    private String title;
    private String imgPath;
    private String desc;
    private String status;
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
   // @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
