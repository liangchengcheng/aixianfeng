package com.lcc.service.Article;

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