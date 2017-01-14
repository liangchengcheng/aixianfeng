package com.lcc.service.Article;

import com.lcc.core.orm.PageRequest;
import com.lcc.core.orm.Pagination;
import com.lcc.dao.ArticleInfoMapper;
import com.lcc.dao.ArticleReadLogMapper;
import com.lcc.service.CommonUtilsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lcc on 2017/1/14.
 */
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource
    private ArticleReadLogMapper articleReadLogMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;


    public ArticleInfoVO findArticleBySlug(Long slug, String ipAddress) {
        return null;
    }

    public Pagination<ArticleInfoVO> page(PageRequest pageRequest, HttpServletRequest request) {
        return null;
    }
}
