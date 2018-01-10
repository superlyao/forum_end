package com.yliao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yliao
 * @Date 2018/1/10.
 */
@Controller
public class AppController {
    @RequestMapping(value = "/")
    public String index() {
        return "test";
    }
}
