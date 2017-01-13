package com.lcc.dao;

import com.lcc.domain.BookInfo;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> selectAll();

    BookInfo selectBySlug(Long slug);
}