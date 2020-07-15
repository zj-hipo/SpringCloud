package com.zj.controller;

import com.zj.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: springCloud1
 * @description: 负载均衡，记得关掉Hystrix，不然运行错误
 * @author: 张军
 * @create: 2020-07-15 08:40
 **/
@Controller
@RequestMapping("/user-ribbon")
public class UserRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{id}")
    @ResponseBody
    public News query(@PathVariable int id){

        // 获取ip和端口信息
        String baseUrl = "http://user-provider/"+id;
        News news=restTemplate.getForObject(baseUrl,News.class);
        System.out.println(baseUrl);
        return news;
    }
}
