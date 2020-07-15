package com.zj.service;

import com.zj.pojo.News;

import java.util.List;

/**
 * @program: springboot_crud
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-06-08 20:59
 **/

public interface NewsService {
     News queryById(int id);
}
