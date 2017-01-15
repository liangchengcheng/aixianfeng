package com.lcc.web.controller.articlemanage;

import com.google.common.collect.Maps;
import com.lcc.domain.ArticleInfo;
import com.lcc.service.Article.ManageArticleInfoService;
import com.lcc.service.category.CategoryInfoService;
import com.lcc.service.category.SimpleCategoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/15.
 */
@Controller
@RequestMapping(value = "manage/acticle")
public class ManageArticleController {

    @Resource(name = "manageArticleInfoService")
    private ManageArticleInfoService manageArticleInfoService;

    @Resource(name = "categoryInfoService")
    private CategoryInfoService categoryInfoService;

    public String index(@RequestParam(value = "categorySlug", required = false)Long categorySlug,  Model model){
        List<ArticleInfo> articleInfoList =  manageArticleInfoService.findListByCategorySlug(categorySlug);
        model.addAttribute("articleInfoList", articleInfoList);
        return "manage/article/article_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String edit(Model model){
        List<SimpleCategoryInfo> categoryInfoList = categoryInfoService.findSimpleCategoryInfo();

        model.addAttribute("categoryList", categoryInfoList);
        model.addAttribute("type", 1);
        return "manage/article/article_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@ModelAttribute ArticleInfoFormBean articleInfoFormBean, Model model){
        manageArticleInfoService.insert(articleInfoFormBean);

        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        ArticleInfo articleInfo = manageArticleInfoService.findById(id);
        List<SimpleCategoryInfo> categoryInfoList = categoryInfoService.findSimpleCategoryInfo();

        model.addAttribute("categoryList", categoryInfoList);
        model.addAttribute("articleInfo", articleInfo);
        model.addAttribute("type", 2);
        return "manage/article/article_add";
    }

    @RequestMapping(value = "/update")
    public String update(@ModelAttribute ArticleInfoFormBean articleInfoFormBean, Model model){
        manageArticleInfoService.updateArticle(articleInfoFormBean);

        return "redirect:list";
    }


    @RequestMapping(value = "/enabled", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateEnabled(@RequestParam("id") Integer id){
        Map<String, Object> map = Maps.newHashMap();
        int status = manageArticleInfoService.updateArticleEnabled(id);

        map.put("status", status);
        return map;
    }
}
