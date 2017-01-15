package com.lcc.web.controller;

import com.google.common.collect.Maps;
import com.lcc.service.Article.ArticleInfoVO;
import com.lcc.service.category.CategoryInfoService;
import com.lcc.service.category.CategoryInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Resource(name = "categoryInfoService")
    private CategoryInfoService categoryInfoService;

    //------------------移动端---------------------
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if (!mobile) {
            return "redirect:#/category";
        }

        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoVOList.get(0).getArticleInfoVOList();

        model.addAttribute("categoryInfoVOList", categoryInfoVOList);
        model.addAttribute("articleInfoVOList", articleInfoVOList.size() > 0 ? articleInfoVOList : null);
        model.addAttribute("num", categoryInfoVOList.size());
        return "web/category/category_mobile";
    }

    @RequestMapping(value = "/category/{slug}/list", method = RequestMethod.GET)
    public String category(@PathVariable Long slug, HttpServletRequest request, Model model){
        Boolean mobile = (Boolean) request.getAttribute("mobile");
        if (!mobile) {
            return "redirect:/#/category/" + slug;
        }

        List<ArticleInfoVO> articleInfoVOList = categoryInfoService.findArticleListByCategory(slug);

        model.addAttribute("articleInfoVOList", articleInfoVOList);
        model.addAttribute("slug", slug);
        return "web/common/detail";
    }

    //------------------PC端----------------------------
    @RequestMapping(value = "/category/layout", method = RequestMethod.GET)
    public String layout() {

        return "web/category/layout";
    }


    @RequestMapping(value ="/categoryList", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, Model model) {
        Map<String, Object> map = Maps.newHashMap();

        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoVOList.get(0).getArticleInfoVOList();
        map.put("categoryInfoVOList", categoryInfoVOList);
        map.put("articleInfoVOList", articleInfoVOList.size() > 0 ? articleInfoVOList : null);

        return map;
    }

    @RequestMapping(value ="/category/{slug}", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseBody
    public Map<String, Object> listBySlug(@PathVariable Long slug, HttpServletRequest request, Model model) {
        Map<String, Object> map = Maps.newHashMap();

        List<CategoryInfoVO> categoryInfoVOList = categoryInfoService.findCategoryInfoVO();
        List<ArticleInfoVO> articleInfoVOList = categoryInfoService.findArticleListByCategory(slug);
        map.put("categoryInfoVOList", categoryInfoVOList);
        map.put("articleInfoVOList", articleInfoVOList);

        return map;
    }
}
