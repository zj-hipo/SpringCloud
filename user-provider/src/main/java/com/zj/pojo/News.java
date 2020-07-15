package com.zj.pojo;
import java.util.Date;

/**
 * @program: springboot_crud
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-06-08 20:46
 **/

public class News {
    private Integer newsId;
    private  String newsTitle;
    private  String newsContent;
    private Date newsTime;
    private String adminName;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsTime=" + newsTime +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
