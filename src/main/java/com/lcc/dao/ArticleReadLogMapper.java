package com.lcc.dao;

import com.lcc.domain.ArticleReadLog;

/**
 * Created by lcc on 2017/1/13.
 */
public interface ArticleReadLogMapper {

    int insert(ArticleReadLog record);

    /**
     * 查看文章点击次数
     * @param articleSlug 文章slug
     * @return 点击次数
     */
    Long queryForClickNumByArticle(Long articleSlug);
}
