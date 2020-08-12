package com.zj.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zj.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: springCloud1
 * @description: 呵呵
 * @author: 张军
 * @create: 2020-07-15 16:09
 **/
@Controller
@RequestMapping("/user-consumer")
public class UserFeignController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public News query(@PathVariable int id){
        //根据服务id获取实例
        discoveryClient.getInstances("user-provider");
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/"+id;
        News news=restTemplate.getForObject(baseUrl,News.class);
        return news;
    }
    public News queryUserByIdFallback(@PathVariable int id){
        News news = new News();
        news.setNewsTitle("服务器异常");
        return news;
    }
}
