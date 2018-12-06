package com.baizhi.test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artical {
    private String id;
    private String price;
    private String desc;
    private String img;
    private String status;

    private String address;

    private String date;
}
