package com.yliao.service;

import com.yliao.bean.UserInfo;
import com.yliao.exception.BusinessException;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 * 邮件服务
 */
public interface IEmailService {
    /**
     * 激活用户
     * @param userInfo
     */
    void activateUser(UserInfo userInfo) throws BusinessException;
}
