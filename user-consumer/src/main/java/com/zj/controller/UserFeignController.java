package com.zj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zj.client.UserFeignClient;
import com.zj.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springCloud1
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-07-15 16:09
 **/
@Controller
@RequestMapping("/user-feign")
public class UserFeignController {
    @Autowired
    private UserFeignClient userFeignClient;
    @RequestMapping("/{id}")
    @ResponseBody
    public News query(@PathVariable int id){
        News news=userFeignClient.feignQuery(id);
        return news;
    }
}
