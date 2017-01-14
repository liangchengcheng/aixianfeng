package com.lcc.service.category;

/**
 * Created by lcc on 2017/1/14.
 */
public class SimpleCategoryInfo {
    private Long categorySlug;

    private String title;

    private Integer num;

    public Long getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(Long categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
