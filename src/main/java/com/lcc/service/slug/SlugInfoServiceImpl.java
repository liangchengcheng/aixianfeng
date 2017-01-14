package com.lcc.service.slug;

import com.google.common.collect.Sets;
import com.lcc.core.utils.RandomUtils;
import com.lcc.dao.SlugInfoMapper;
import com.lcc.domain.SlugInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
/**
 * Created by lcc on 2017/1/14.
 */
@Service(value = "slugInfoService")
@Transactional
public class SlugInfoServiceImpl implements SlugInfoService {

    @Autowired
    private SlugInfoMapper slugInfoMapper;

    public void insert(){
        Set<String> strSet = Sets.newHashSet();

        for(int i = 0; i < 2000; i++){
            strSet.add(RandomUtils.generateNumber2());
        }

        Object[] strList = strSet.toArray();

        for(int i = 0; i < strList.length; i++){
            SlugInfo slugInfo = new SlugInfo();
            slugInfo.setSlug(Long.valueOf(String.valueOf(strList[i])));
            slugInfoMapper.insert(slugInfo);
        }
    }
}
