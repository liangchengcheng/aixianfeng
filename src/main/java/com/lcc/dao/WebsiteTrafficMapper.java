package com.lcc.dao;

/**
 * Created by lcc on 2017/1/13.
 */
import com.lcc.domain.WebsiteTraffic;
import java.util.List;

public interface WebsiteTrafficMapper {

    int insert(WebsiteTraffic record);

    List<WebsiteTraffic> queryByIpAddress(String ipAddress);
}