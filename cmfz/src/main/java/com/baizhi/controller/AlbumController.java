package com.baizhi.controller;
import com.baizhi.service.AlbumService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/albumall")
    public @ResponseBody  Map selectAll(){
        return  albumService.selectAll();
    }
    @RequestMapping("/add")
    public void addChapter(MultipartFile chapter, String title, String id, HttpServletRequest request) {
        /*
         * &#x8c03;&#x7528;&#x4e1
         * a;&#x52a1;
         * &#x83b7;&#x53d6;&#x5927;&#x5c0f;&#x65f6;&#x957f;
         * &#x4fdd;&#x5b58;&#x6587;&#x4ef6;   //&#x6587;&#x4ef6;&#x4e0a;&#x4f20; &#x6587;&#x4ef6;&#x4fdd;&#x5b58;&#x5230;&#x90a3; &#x6587;&#x4ef6;&#x91cd;&#x540d;  &#x5c06;&#x6587;&#x4ef6;&#x4fdd;&#x5b58;&#x5230;&#x6307;&#x5b9a;&#x76ee;&#x5f55;
         * &#x4fdd;&#x5b58;&#x6570;&#x636e;
         * */
        String realPath = request.getSession().getServletContext().getRealPath("/");  //webapp当前项目的路径
        File file = new File(realPath + "/upload");
        if (!file.exists()) {
            file.mkdir();
        }

        //测试音乐.MP3   11111111.MP3
        String extension = FilenameUtils.getExtension(chapter.getOriginalFilename());
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String newName = s + "." + extension;

        try {
            chapter.transferTo(new File(file.getAbsolutePath(), newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
        long size = chapter.getSize();
        double l = size / 1024.0 / 1024.0;
        System.out.println(l);


        //文件大小  时长  名字  url   date
    }

    //7e575547-a5f0-4b4f-ba0e-39c71de680fc.mp3
    @RequestMapping("/download")
    public void download(String url, String title, HttpServletRequest request, HttpServletResponse response) {
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");  //webapp当前项目的路径
        String path = uploadPath + "/" + url;
        File file = new File(path);

        String s = title + "." + "mp3";


        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
