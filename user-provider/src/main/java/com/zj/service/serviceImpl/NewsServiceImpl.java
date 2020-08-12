package com.zj.service.serviceImpl;

import com.zj.mapper.NewsMapper;
import com.zj.pojo.News;
import com.zj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springboot_crud
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-06-08 21:02
 **/
@Transactional
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public News queryById(int id) {
        /*休眠测试
        * 为了测试Hystrix
        * */
        try {
            //这里测试hystrix的时候，睡眠设置为2000毫秒以上才有效果；这里为了测试feign将时间设置为1000，不让其超时
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newsMapper.queryById(id);
    }
}
