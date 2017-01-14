package com.lcc.service;

import com.lcc.domain.ArticleInfo;
import com.lcc.service.Article.ArticleInfoVO;
import com.lcc.service.Article.SimpleArticleInfo;

/**
 * Created by lcc on 2017/1/14.
 */
public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);

    SimpleArticleInfo transArticleToSimpleArticle(ArticleInfo articleInfo);
}
