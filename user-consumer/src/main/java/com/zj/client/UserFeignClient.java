package com.zj.client;

import com.zj.pojo.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringCloud0805
 * @description: Feign
 * @author: 张军
 * @create: 2020-08-12 14:27
 **/
@FeignClient("user-provider")
public interface UserFeignClient {
    @RequestMapping("/{id}")
    public News queryNews(@PathVariable("id") int id);
}
