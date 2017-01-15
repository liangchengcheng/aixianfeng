package com.lcc.web.intercept;

/**
 * Created by lcc on 2017/1/15.
 */

import com.lcc.core.utils.GenerateUtils;
import com.lcc.domain.WebsiteTraffic;
import com.lcc.service.log.WebsiteTrafficService;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Resource(name = "websiteTrafficService")
    private WebsiteTrafficService websiteTrafficService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //判断设备
        String userAgentStr = httpServletRequest.getHeader("User-Agent");
        UserAgent userAgent = new UserAgent(userAgentStr);
        DeviceType deviceType = userAgent.getOperatingSystem().getDeviceType();

        //判断是手机端访问的吗?
        if (DeviceType.MOBILE.equals(deviceType)) {
            httpServletRequest.setAttribute("mobile", true);
        } else if (DeviceType.TABLET.equals(deviceType)) {
            httpServletRequest.setAttribute("mobile", false);
        } else {
            httpServletRequest.setAttribute("mobile", false);
        }

        //获取访问者的IP
        String realIp = GenerateUtils.getIpAddress(httpServletRequest);
        httpServletRequest.setAttribute("realIp", realIp);
        WebsiteTraffic websiteTraffic = new WebsiteTraffic();
        websiteTraffic.setBrowser(userAgent.getBrowser().getName());
        websiteTraffic.setCreateTime(new Date());
        websiteTraffic.setOperateSystem(userAgent.getOperatingSystem().getName());
        websiteTraffic.setIpAddress((realIp == null) ? "127.0.0.1" : realIp);

        //设置模式,默认为夜间模式
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("mo") == null){
            //夜间模式
            httpServletRequest.getSession().setAttribute("mo","1");
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
