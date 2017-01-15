package com.lcc.web.controller;

import com.google.common.collect.Maps;
import com.lcc.core.orm.PageRequest;
import com.lcc.core.orm.Pagination;
import com.lcc.service.Article.ArticleInfoService;
import com.lcc.service.Article.ArticleInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource(name = "articleInfoService")
    private ArticleInfoService articleInfoService;

    //-------------移动端----------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");

        if(mobile) {
            PageRequest pageRequest = new PageRequest(1, 10);

            Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest, request);
            ArticleInfoVO firstArticleInfoVO = null;
            if(pagination.getItems().size() > 0){
                firstArticleInfoVO = pagination.getItems().get(0);
            }

            model.addAttribute("pagination", pagination);
            model.addAttribute("firstArticle", firstArticleInfoVO);

            return "web/index/index_mobile";
        }else {
            return "web/home";
        }
    }

    //-----------------------PC端---------------------------
    @RequestMapping(value = "/index/layout", method = RequestMethod.GET)
    public String layout(HttpServletRequest request, Model model){

        return "web/index/layout";
    }

    @RequestMapping(value ="/topTenArticle", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, Model model){
        Integer page = 1;
        PageRequest pageRequest = new PageRequest(page, 10);

        Pagination<ArticleInfoVO> pagination = articleInfoService.page(pageRequest, request);

        ArticleInfoVO firstArticleInfoVO = null;
        if(pagination.getItems().size() > 0){
            firstArticleInfoVO = pagination.getItems().get(0);
        }

        Map<String, Object> map = Maps.newHashMap();
        map.put("pagination", pagination);
        map.put("firstArticle", firstArticleInfoVO);
        map.put("detail", false);

        return map;
    }
}
