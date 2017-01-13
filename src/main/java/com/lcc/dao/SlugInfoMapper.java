package com.lcc.dao;

import com.lcc.domain.SlugInfo;

/**
 * Created by lcc on 2017/1/13.
 */
public interface SlugInfoMapper {

    int insert(SlugInfo record);

    SlugInfo queryById(Integer id);
}