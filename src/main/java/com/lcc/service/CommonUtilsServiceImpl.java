package com.lcc.service;

/**
 * Created by lcc on 2017/1/15.
 */
import com.lcc.core.utils.GenerateUtils;
import com.lcc.dao.ArticleInfoMapper;
import com.lcc.dao.ArticleReadLogMapper;
import com.lcc.dao.CategoryInfoMapper;
import com.lcc.domain.ArticleInfo;
import com.lcc.domain.CategoryInfo;
import com.lcc.service.Article.ArticleInfoVO;
import com.lcc.service.Article.SimpleArticleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service("commonUtilsService")
@Transactional
public class CommonUtilsServiceImpl implements CommonUtilsService{

    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleReadLogMapper articleReadLogMapper;

    public ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo){

        ArticleInfoVO articleInfoVO = new ArticleInfoVO();

        articleInfoVO.setTitle(articleInfo.getTitle());
        articleInfoVO.setDescription(articleInfo.getDescription());
        articleInfoVO.setContent(articleInfo.getContent());
        articleInfoVO.setTags(GenerateUtils.spiltStringByComma(articleInfo.getTag()));
        articleInfoVO.setCreateTime(articleInfo.getCreateTime());
        articleInfoVO.setArticleSlug(articleInfo.getSlug());
        articleInfoVO.setCategorySlug(articleInfo.getCategorySlug());
        articleInfoVO.setLikeNum(articleInfo.getThumb());


        Long categorySlug = articleInfo.getCategorySlug();
        CategoryInfo categoryInfo = categoryInfoMapper.selectBySlug(categorySlug);
        articleInfoVO.setCategoryName(categoryInfo.getTitle());

        Long clickNum = articleReadLogMapper.queryForClickNumByArticle(articleInfo.getSlug());
        articleInfoVO.setReviewNum(clickNum);

        return articleInfoVO;
    }


    public SimpleArticleInfo transArticleToSimpleArticle(ArticleInfo articleInfo){
        SimpleArticleInfo simpleArticleInfo = new SimpleArticleInfo();

        simpleArticleInfo.setCreateTime(articleInfo.getCreateTime());
        simpleArticleInfo.setSlug(articleInfo.getSlug());
        simpleArticleInfo.setTitle(articleInfo.getTitle());
        return simpleArticleInfo;
    }
}
