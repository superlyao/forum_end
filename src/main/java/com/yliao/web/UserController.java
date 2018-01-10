package com.yliao.web;

import com.yliao.bean.UserInfo;
import com.yliao.bean.vo.ResultInfo;
import com.yliao.common.Log;
import com.yliao.common.Util;
import com.yliao.exception.BusinessException;
import com.yliao.service.IEmailService;
import com.yliao.service.IUserService;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IEmailService iEmailService;

    /**
     * 新建用户
     *
     * @param request  当前的请求
     * @param userInfo 用户信息
     * @return 新建是否成功
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultInfo userRegister(HttpServletRequest request, UserInfo userInfo, @RequestParam("file") MultipartFile file) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            if (file.isEmpty()) {
                throw new BuilderException("用户头像不能为空");
            }
            if (file.getContentType().indexOf("image") == -1) {
                throw new BuilderException("用户头像只能上传图片");
            }
            UserInfo resultUserInfo = iUserService.queryUserByUserName(userInfo.getUserName());
            if (resultUserInfo != null) {
                throw new BusinessException("用户名已存在");
            }
            String requestUrl = request.getRequestURL().toString();
            String requestPort = requestUrl.substring(0, requestUrl.indexOf("forum") - 1);
            String imageType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            InputStream inputStream = file.getInputStream();
            userInfo.setUserFace(requestPort + seveImage(request, inputStream, imageType));
            userInfo.setIsActivate(0);
            if (iUserService.saveUser(userInfo)) {
                resultInfo.setSuccess(true);
                resultInfo.setMessage("注册成功");
                // 发送激活邮件
                iEmailService.activateUser(userInfo);
            }
        } catch (Exception e) {
            Log.error(this.getClass(), e.getMessage());
            throw new BuilderException(e.getMessage());
        }
        return resultInfo;
    }

    /**
     * 激活账号
     * @param userId
     * @throws BusinessException
     */
    @RequestMapping(value = "/activateUser/{userId}", method = RequestMethod.GET)
    public ModelAndView activateUser(@PathVariable String userId) throws BusinessException {
        try {
            if (Util.isEmpty(userId)) {
                throw new BusinessException("非法请求");
            }
            UserInfo userInfo = iUserService.queryUserByID(userId);
            if (userInfo == null) {
                throw new BusinessException("该账号不存在");
            }
            boolean resultType = iUserService.changeUserActivateType(userId);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("userName", userInfo.getUserName());
            if (resultType) {
                modelAndView.addObject("type", "激活成功,点击一下链接进入论坛");
                modelAndView.addObject("url", "");
            } else {
                modelAndView.addObject("type", "激活失败,请重新激活或重新注册");
            }
            modelAndView.setViewName("activate");
            return modelAndView;
        } catch (Exception e) {
            Log.error(e.getClass(), e.getMessage());
            throw new BusinessException(e.getMessage());
        }

    }

    /**
     * 保存用户头像
     *
     * @param request
     * @param inputStream
     * @param imageType
     * @return
     * @throws IOException
     */
    private String seveImage(HttpServletRequest request, InputStream inputStream, String imageType) throws IOException {
        String realPath = request.getServletContext().getRealPath("/");
        String parentPath = new File(realPath).getParent() + Util.IMAGE_PATH;
        Log.info(this.getClass(), parentPath);
        File file = new File(parentPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String imageId = Util.getUUID();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(parentPath + "/" + imageId + imageType));
        byte[] bytes = new byte[1024 * 8];
        while (true) {
            int read = 0;
            if (inputStream != null) {
                read = inputStream.read(bytes);
            }
            if (read == -1) {
                break;
            }
            fileOutputStream.write(bytes, 0, read);
        }
        fileOutputStream.flush();
        if (inputStream != null) {
            inputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return Util.IMAGE_PATH + "/" + imageId + imageType;
    }
}
