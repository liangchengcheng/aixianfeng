package com.lcc.service.Article;

import com.lcc.dao.ArticleInfoMapper;
import com.lcc.dao.SlugInfoMapper;
import com.lcc.domain.ArticleInfo;
import com.lcc.domain.SlugInfo;
import com.lcc.web.controller.articlemanage.ArticleInfoFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("manageArticleInfoService")
@Transactional
public class ManageArticleInfoServiceImpl implements ManageArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private SlugInfoMapper slugInfoMapper;

    public void insert(ArticleInfoFormBean articleInfoFormBean) throws RuntimeException{
        ArticleInfo articleInfo = transFormBeanToArticle(articleInfoFormBean);
        articleInfoMapper.insert(articleInfo);

        SlugInfo slugInfo = slugInfoMapper.queryById(articleInfo.getId());
        articleInfo.setSlug(slugInfo.getSlug());
        articleInfoMapper.update(articleInfo);
    }

    public List<ArticleInfo> findListByCategorySlug(Long categorySlug) {
        List<ArticleInfo> articleInfoList;
        if (null == categorySlug){
            articleInfoList = articleInfoMapper.findList();
            //articleInfoList = articleInfoMapper.findList();
        }else{
            articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);
        }

        return articleInfoList;
    }

    public int updateArticleEnabled(int articleId) {
        ArticleInfo articleInfo = articleInfoMapper.findById(articleId);

        boolean enabled = articleInfo.getEnabled();
        if(enabled){
            enabled = false;
        }else {
            enabled = true;
        }
        articleInfo.setEnabled(enabled);

        return articleInfoMapper.update(articleInfo);
    }

    public ArticleInfo findById(Integer id) {
        ArticleInfo articleInfo = articleInfoMapper.findById(id);
        return articleInfo;
    }

    public int updateArticle(ArticleInfoFormBean articleInfoFormBean) {
        ArticleInfo articleInfo = articleInfoMapper.findById(articleInfoFormBean.getId());
        articleInfo.setTitle(articleInfoFormBean.getTitle());
        articleInfo.setContent(articleInfoFormBean.getContent());
        articleInfo.setCategorySlug(articleInfoFormBean.getCategorySlug());
        articleInfo.setTag(articleInfoFormBean.getTag());
        articleInfo.setDescription(articleInfoFormBean.getDescription());
        articleInfo.setDescriptionMd(articleInfoFormBean.getDescriptionMd());

        return articleInfoMapper.update(articleInfo);
    }

    private ArticleInfo transFormBeanToArticle(ArticleInfoFormBean articleInfoFormBean){
        ArticleInfo articleInfo = new ArticleInfo();

        articleInfo.setCategorySlug(articleInfoFormBean.getCategorySlug());
        articleInfo.setTag(articleInfoFormBean.getTag());
        articleInfo.setTitle(articleInfoFormBean.getTitle());
        articleInfo.setContent(articleInfoFormBean.getContent());
        articleInfo.setDescription(articleInfoFormBean.getDescription());
        articleInfo.setEnabled(true);
        articleInfo.setLastModifyTime(new Date());
        articleInfo.setCreateTime(new Date());
        articleInfo.setThumb(0);

        return articleInfo;
    }
}