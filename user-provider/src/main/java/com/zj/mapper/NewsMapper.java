package com.zj.mapper;


import com.zj.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: springboot_crud
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-06-08 20:46
 **/
@Mapper
public interface NewsMapper {
     List<News> queryAll();
     News queryById(int id);
}
