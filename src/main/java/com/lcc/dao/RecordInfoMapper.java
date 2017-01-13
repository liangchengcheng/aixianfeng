package com.lcc.dao;

/**
 * Created by lcc on 2017/1/13.
 */
import com.lcc.domain.RecordInfo;

import java.util.List;

public interface RecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);

    List<RecordInfo> selectAll();

    RecordInfo selectById(Integer id);
}