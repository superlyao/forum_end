package com.yliao.service;

import com.yliao.bean.UserInfo;
import com.yliao.exception.BusinessException;

/**
 * @Author liaoyao
 * @Date 2018/1/3.
 * 用户service
 */
public interface IUserService {
    /**
     * 保存用户
     * @param userInfo
     * @return
     * @throws BusinessException
     */
    boolean saveUser(UserInfo userInfo) throws BusinessException;
}
