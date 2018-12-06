package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Chapter {
    private String  id;
    private String title;
    private double size;
    private double duration;
    private String downPath;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String  uploadDate;
    private String albumId;
}
