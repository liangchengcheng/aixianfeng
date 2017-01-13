package com.lcc.dao;

/**
 * Created by lcc on 2017/1/13.
 */
import com.lcc.domain.CategoryInfo;

import java.util.List;

public interface CategoryInfoMapper {

    CategoryInfo selectBySlug(Long slug);

    List<CategoryInfo> selectAll();

    int save(CategoryInfo categoryInfo);

    void update(CategoryInfo categoryInfo);

    void updateBySlug(CategoryInfo categoryInfo);
}
