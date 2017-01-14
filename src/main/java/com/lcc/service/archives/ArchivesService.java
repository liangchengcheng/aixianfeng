package com.lcc.service.archives;

import com.lcc.service.Article.ArticleInfoVO;

import java.text.ParseException;
import java.util.List;

public interface ArchivesService {

    List<ArchivesVO> findArchivesList() throws ParseException;

    List<ArticleInfoVO> findArticleByMonth(String timeStamp) throws ParseException;
}
