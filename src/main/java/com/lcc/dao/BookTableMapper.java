package com.lcc.dao;

/**
 * Created by lcc on 2017/1/13.
 */
import com.lcc.domain.BookTable;

import java.util.List;

public interface BookTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookTable record);

    BookTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BookTable record);

    List<BookTable> selectAll();
}
