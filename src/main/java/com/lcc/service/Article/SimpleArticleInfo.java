package com.lcc.service.Article;

import java.util.Date;

/**
 * Created by lcc on 2017/1/14.
 */
public class SimpleArticleInfo {

    private Date createTime;

    private String title;

    private Long slug;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSlug() {
        return slug;
    }

    public void setSlug(Long slug) {
        this.slug = slug;
    }
}
