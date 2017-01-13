package com.lcc.dao;

import com.lcc.domain.BookReadLog;

/**
 * Created by lcc on 2017/1/13.
 */

public interface BookReadLogMapper {
    int insert(BookReadLog record);

    BookReadLog selectByPrimaryKey(Long id);

    Long selectNumById(Integer id);
}