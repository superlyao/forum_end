package com.yliao.web;

import com.yliao.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liaoyao on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class CenterController {
    @RequestMapping("/main")
    public String index() {
        String a = "1";
        LogUtil.info(getClass(), "开始联调");
        return "main";
    }
}
