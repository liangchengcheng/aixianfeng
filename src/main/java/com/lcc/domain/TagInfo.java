package com.lcc.domain;

import java.util.Date;

/**
 * Created by lcc on 2017/1/13.
 */
public class TagInfo {
    private Integer id;

    private Date createTime;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.title = title == null ? null : title.trim();
    }
}
