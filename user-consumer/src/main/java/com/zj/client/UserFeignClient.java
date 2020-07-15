package com.zj.client;

import com.zj.pojo.News;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springCloud1
 * @description: feign远程调用
 * @author: 张军
 * @create: 2020-07-15 16:05
 **/
/*String baseUrl = "http://user-provider/"+id;
 *String news=restTemplate.getForObject(baseUrl,String.class);
 */
@FeignClient("user-provider")
public interface UserFeignClient {
    @RequestMapping("/{id}")
    News feignQuery(@PathVariable int id);
}
