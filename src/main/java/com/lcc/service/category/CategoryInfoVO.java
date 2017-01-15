package com.lcc.service.category;

import com.lcc.service.Article.ArticleInfoVO;

import java.util.List;

/**
 * Created by lcc on 2017/1/15.
 */
public class CategoryInfoVO {

    private Long slug;

    private String categoryTitle;

    private List<ArticleInfoVO> articleInfoVOList;

    public Long getSlug() {
        return slug;
    }

    public void setSlug(Long slug) {
        this.slug = slug;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<ArticleInfoVO> getArticleInfoVOList() {
        return articleInfoVOList;
    }

    public void setArticleInfoVOList(List<ArticleInfoVO> articleInfoVOList) {
        this.articleInfoVOList = articleInfoVOList;
    }
}
