package com.lcc.service.category;

/**
 * Created by lcc on 2017/1/15.
 */

import com.lcc.domain.CategoryInfo;

import java.util.List;

public interface ManageCategoryService {

    void insert(CategoryInfo categoryInfo);

    List<SimpleCategoryInfo> list();

    int updateBySlug(CategoryInfo categoryInfo);
}
