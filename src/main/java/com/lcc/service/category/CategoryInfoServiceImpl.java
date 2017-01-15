package com.lcc.service.category;

import com.google.common.collect.Lists;
import com.lcc.dao.ArticleInfoMapper;
import com.lcc.dao.CategoryInfoMapper;
import com.lcc.domain.ArticleInfo;
import com.lcc.domain.CategoryInfo;
import com.lcc.service.Article.ArticleInfoVO;
import com.lcc.service.CommonUtilsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lcc on 2017/1/15.
 */
@Service(value = "categoryInfoService")
@Transactional
public class CategoryInfoServiceImpl implements CategoryInfoService{


    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArticleInfoVO> findArticleListByCategory(Long categorySlug){
        List<ArticleInfoVO> articleInfoVOList = Lists.newArrayList();
        List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);

        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        return articleInfoVOList;
    }

    public List<CategoryInfoVO> findCategoryInfoVO(){
        List<CategoryInfoVO> categoryInfoVOList = Lists.newArrayList();

        List<CategoryInfo> categoryInfoList = categoryInfoMapper.selectAll();

        for(CategoryInfo categoryInfo : categoryInfoList){
            CategoryInfoVO categoryInfoVO = new CategoryInfoVO();
            categoryInfoVO.setCategoryTitle(categoryInfo.getTitle());
            categoryInfoVO.setSlug(categoryInfo.getSlug());

            List<ArticleInfoVO> articleInfoVOList = findArticleListByCategory(categoryInfo.getSlug());
            categoryInfoVO.setArticleInfoVOList(articleInfoVOList);

            categoryInfoVOList.add(categoryInfoVO);
        }
        return categoryInfoVOList;
    }

    public List<SimpleCategoryInfo> findSimpleCategoryInfo() {
        List<SimpleCategoryInfo> simpleCategoryInfoList = Lists.newArrayList();

        List<CategoryInfo> categoryInfoList = categoryInfoMapper.selectAll();
        for(CategoryInfo categoryInfo : categoryInfoList){
            simpleCategoryInfoList.add(transToSimpleCategoryInfo(categoryInfo));
        }

        return simpleCategoryInfoList;
    }

    private SimpleCategoryInfo transToSimpleCategoryInfo(CategoryInfo categoryInfo){
        SimpleCategoryInfo simpleCategoryInfo = new SimpleCategoryInfo();

        simpleCategoryInfo.setTitle(categoryInfo.getTitle());
        simpleCategoryInfo.setCategorySlug(categoryInfo.getSlug());

        return simpleCategoryInfo;
    }


}
