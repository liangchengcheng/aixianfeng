package com.lcc.dao;

/**
 * Created by lcc on 2017/1/13.
 */
import com.lcc.domain.PicInfo;

import java.util.List;

public interface PicInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PicInfo record);

    List<PicInfo> selectAll();

    PicInfo selectById(Long id);
}