package com.lcc.service.category;

import com.google.common.collect.Lists;
import com.lcc.dao.ArticleInfoMapper;
import com.lcc.dao.CategoryInfoMapper;
import com.lcc.dao.SlugInfoMapper;
import com.lcc.domain.ArticleInfo;
import com.lcc.domain.CategoryInfo;
import com.lcc.domain.SlugInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lcc on 2017/1/15.
 */
@Service(value = "manageCategoryService")
public class ManageCategoryServiceImpl implements ManageCategoryService{

    @Autowired
    private CategoryInfoMapper categoryInfoMapper;

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private SlugInfoMapper slugInfoMapper;

    public void insert(CategoryInfo categoryInfo){
        categoryInfo.setCreateTime(new Date());
        categoryInfoMapper.save(categoryInfo);

        SlugInfo slugInfo = slugInfoMapper.queryById(categoryInfo.getId());
        categoryInfo.setSlug(slugInfo.getSlug());
        categoryInfoMapper.update(categoryInfo);
    }

    public List<SimpleCategoryInfo> list(){
        List<SimpleCategoryInfo> simpleCategoryInfoList = Lists.newArrayList();

        List<CategoryInfo> categoryInfoList =categoryInfoMapper.selectAll();
        for (CategoryInfo categoryInfo: categoryInfoList) {
            SimpleCategoryInfo simpleCategoryInfo = new SimpleCategoryInfo();
            simpleCategoryInfo.setCategorySlug(categoryInfo.getSlug());
            simpleCategoryInfo.setTitle(categoryInfo.getTitle());

            List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categoryInfo.getSlug());
            simpleCategoryInfo.setNum(articleInfoList == null ? 0 : articleInfoList.size());

            simpleCategoryInfoList.add(simpleCategoryInfo);
        }

        return simpleCategoryInfoList;
    }

    // TODO: 2017/1/15 此处需要做修改? 
    public int updateBySlug(CategoryInfo categoryInfo){
        categoryInfoMapper.updateBySlug(categoryInfo);
        return 0;
    }
}
