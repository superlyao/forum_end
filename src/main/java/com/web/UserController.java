package com.web;

import com.bean.UserInfo;
import com.bean.vo.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author liaoyao
 * @Date 2018/1/3.
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 新建用户
     * @param request 当前的请求
     * @param userInfo 用户信息
     * @return 新建是否成功
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultInfo userRegister (HttpServletRequest request, UserInfo userInfo) {
        ResultInfo resultInfo = new ResultInfo();
        request.getSession();
        return resultInfo;
    }
}
