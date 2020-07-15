package com.zj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zj.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springCloud1
 * @description: 降级服务
 * @author: 张军
 * @create: 2020-07-15 11:05
 **/
@Controller
@RequestMapping("/user-hystrix")
public class UserHystrixController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "queryFallBack")
    public String query(@PathVariable int id){
        String baseUrl = "http://user-provider/"+id;
        String news=restTemplate.getForObject(baseUrl,String.class);
        System.out.println(baseUrl);
        return news;
    }
    /*
    * 失败返回的方法
    * 返回值、参数列表必须和上面的一样，也就是俩方法的业务逻辑得相同
    * */
    public String queryFallBack(@PathVariable int id){

        return "服务器太卡啦！！！";
    }
}
