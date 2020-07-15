package com.zj.controller;

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
 * @description: 一般的写法,启动这个程序的时候，记得关掉ribbon，不然无法访问
 * @author: 张军
 * @create: 2020-07-14 17:26
 **/
@Controller
@RequestMapping("/user-consumer")
public class UserConsumer {
    @Autowired
    private RestTemplate template;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/{id}")
    @ResponseBody
    public News queryUserByIds(@PathVariable int id) {
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/"+id;
        News news=template.getForObject(baseUrl,News.class);
        return news;
    }
}
