package com.zj.controller;

import com.zj.pojo.News;
import com.zj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springCloud1
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-07-14 16:22
 **/
@Controller
public class UserController {
    @Autowired
    private NewsService newsService;
    @ResponseBody
    @RequestMapping("/send")
    public String send(){
        return "OK!!!";
    }
    @ResponseBody
    @RequestMapping("/{id}")
    public News queryById(@PathVariable int id){
        News news=newsService.queryById(id);
        return news;

    }
}
