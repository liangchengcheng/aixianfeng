package com.lcc.service.archives;

import com.lcc.service.Article.ArticleInfoVO;

import java.util.Date;
import java.util.List;

/**
 * Created by lcc on 2017/1/14.
 */
public class ArchivesVO {

    private Date timeStamp;

    List<ArticleInfoVO> articleInfoVOList;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<ArticleInfoVO> getArticleInfoVOList() {
        return articleInfoVOList;
    }

    public void setArticleInfoVOList(List<ArticleInfoVO> articleInfoVOList) {
        this.articleInfoVOList = articleInfoVOList;
    }
}
