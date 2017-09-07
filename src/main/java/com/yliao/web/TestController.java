package com.yliao.web;

import com.yliao.dao.BookDAO;
import com.yliao.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yliao.service.CacheService;

import java.util.List;


/**
 * Created by superyao12@sina.com on 2017-09-06 22:10:20.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    CacheService cacheService;

    @Autowired
    BookDAO bookDAO;

    /**
     * 测试数据库是否正常
     *
     * @return
     */
    @RequestMapping("/database")
    public String testDatabase(Model model) {
        StringBuilder builder = new StringBuilder();
        List<Book> list = bookDAO.getAllBooks();
        for (Book book :
                list) {
            builder.append(book.toString()).append("\n");
        }
        if (StringUtils.isEmpty(builder.toString())) {
            model.addAttribute("result", "请先往数据库添加测试数据------");
        }
        model.addAttribute("result", builder.toString());
        return "/testDatabase";
    }

    /**
     * 测试页面跳转是否正常
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String testPage(Model model) {
        System.out.println("success!!!!");
        model.addAttribute("result", "project is running successfully!!!");
        return "/index";
    }

    /**
     * 测试cache配置是否成功
     *
     * @return
     */
    @RequestMapping("/cache")
    public String testCache() {
        String value = cacheService.testCache("cacheTest");
        return "/cacheTest";
    }

    @RequestMapping("/nositemesh")
    public String noSitemesh(Model model) {
        model.addAttribute("result", "这是不带有sitemesh的页面");
        return "/nositemesh";
    }
}