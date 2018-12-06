package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("user")
public class User {
    @Excel(name="编号")
    private int id;
    @Excel(name="手机号")
    private String phoneNum;
    @Excel(name="用户名")
    private String username;
    @Excel(name="密码")
    private String password;
    @Excel(name="盐值")
    private String salt;
    @Excel(name="法名")
    private String dharmaName;
    @Excel(name="省份")
    private String province;
    @Excel(name="城市")
    private String city;
    @Excel(name="性别")
    private String sex;
    @Excel(name="签名")
    private String sign;
    @Excel(name="头像")
    private String headPic;
    @Excel(name="状态")
    private String status;
   /* @JsonFormat(pattern = "yyyy-MM-dd")*/
   @Excel(name="时间",exportFormat = "yyyy年MM月dd日",width = 20)
    private Date date;
}
