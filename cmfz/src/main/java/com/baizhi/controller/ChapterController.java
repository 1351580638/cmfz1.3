package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/chapterall")
    public @ResponseBody
    List<Chapter> selectAll() {
        return chapterService.selectAll();
    }

 }
