package com.lcc.dao;

import com.lcc.domain.TagInfo;

/**
 * Created by lcc on 2017/1/13.
 */
public interface TagInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagInfo record);

    int insertSelective(TagInfo record);

    TagInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagInfo record);

    int updateByPrimaryKey(TagInfo record);
}