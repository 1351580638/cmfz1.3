package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;


import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/main")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectUserss")
    public @ResponseBody  List<User> selectAll(){
        List<User>list=userService.selectAll();
        return list;
    }


    @RequestMapping("excl")
    public void out()throws Exception{
        System.out.println("7777777777");
      FileOutputStream fileOutputStream=  new FileOutputStream(new File("F:bbb.xls"));


//          1.生成一个Excel文件
        List<String>titles= Arrays.asList("编号","手机号","用户","密码","盐值","法名","省份","城市","性别","签名","头像","状态","日期");
//           1.1创建一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
//          1.2创建一个工作表
        HSSFSheet user = workbook.createSheet("user");
//              设置宽度
        user.setColumnWidth(3,22*256);
//              设置标题栏样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setColor((short)10);
        font.setFontName("楷体");
        titleStyle.setFont(font);
//        设置日期格式
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年mm月dd日");
        dateStyle.setDataFormat(format);
//           1.3写入标题栏
        HSSFRow titleRow = user.createRow(0);
//           1.4写入用户数据
        for (int i = 0; i <titles.size(); i++) {
            HSSFCell cell = titleRow.createCell(i);
            cell.setCellValue(titles.get(i));
        }
//     2.文件下载
        System.out.println("888");
        workbook.write(new FileOutputStream(new File("F://user.xls")));
}
}
