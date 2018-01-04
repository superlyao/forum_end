package com.yliao.web;

import com.yliao.bean.UserInfo;
import com.yliao.bean.vo.ResultInfo;
import com.yliao.common.Log;
import org.apache.ibatis.builder.BuilderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    public ResultInfo userRegister (HttpServletRequest request, UserInfo userInfo, @RequestParam("file") MultipartFile file) {
        ResultInfo resultInfo = new ResultInfo();
        try {

        } catch (Exception e) {
            Log.error(this.getClass(), e.getMessage());
            throw new BuilderException("新建用户失败");
        }
        request.getSession();
        return resultInfo;
    }
}
