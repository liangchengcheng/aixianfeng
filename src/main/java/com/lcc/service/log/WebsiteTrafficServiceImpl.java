package com.lcc.service.log;

import com.lcc.core.utils.DateFormatUtils;
import com.lcc.dao.WebsiteTrafficMapper;
import com.lcc.domain.WebsiteTraffic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by lcc on 2017/1/14.
 */
@Service(value = "websiteTrafficService")
@Transactional
public class WebsiteTrafficServiceImpl implements WebsiteTrafficService {

    private static Logger logger = LoggerFactory.getLogger(WebsiteTrafficServiceImpl.class);

    @Autowired
    private WebsiteTrafficMapper websiteTrafficMapper;

    public void save(WebsiteTraffic websiteTraffic) {
        String ipAddress = websiteTraffic.getIpAddress();
        List<WebsiteTraffic> websiteTrafficList = websiteTrafficMapper.queryByIpAddress(ipAddress);
        if (!StringUtils.isEmpty(websiteTrafficList) && websiteTrafficList.size() > 0) {
            WebsiteTraffic temp = websiteTrafficList.get(0);
            boolean thanOneHour = DateFormatUtils.isThanOneHour(websiteTraffic.getCreateTime(), temp.getCreateTime());
            //如果间隔小于一小时，则不记录日志
            if (thanOneHour) {
                websiteTrafficMapper.insert(websiteTraffic);
            }
        } else {
            websiteTrafficMapper.insert(websiteTraffic);
        }
    }
}
