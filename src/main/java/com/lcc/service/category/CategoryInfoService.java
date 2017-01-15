package com.lcc.service.category;

/**
 * Created by lcc on 2017/1/15.
 */

import com.lcc.service.Article.ArticleInfoVO;

import java.util.List;

public interface CategoryInfoService {

    List<ArticleInfoVO> findArticleListByCategory(Long categorySlug);

    List<CategoryInfoVO> findCategoryInfoVO();

    List<SimpleCategoryInfo> findSimpleCategoryInfo();
}
