package com.lcc.service.Article;

import com.lcc.core.orm.PageRequest;
import com.lcc.core.orm.Pagination;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lcc on 2017/1/14.
 */
public interface ArticleInfoService {
    ArticleInfoVO findArticleBySlug(Long slug, String ipAddress);

    /**
     * 根据pageRequest分页
     * @return 分页对象
     */
    Pagination<ArticleInfoVO> page(PageRequest pageRequest, HttpServletRequest request);

}
