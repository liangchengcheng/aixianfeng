package com.lcc.service.Article;

import com.lcc.domain.ArticleInfo;
import com.lcc.web.controller.articlemanage.ArticleInfoFormBean;

import java.util.List;

/**
 * Created by lcc on 2017/1/14.
 */
public interface ManageArticleInfoService {

    void insert(ArticleInfoFormBean articleInfoFormBean);

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    int updateArticleEnabled(int articleId);

    ArticleInfo findById(Integer id);

    int updateArticle(ArticleInfoFormBean articleInfoFormBean);
}