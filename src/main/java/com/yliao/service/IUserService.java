package com.yliao.service;

import com.yliao.bean.UserInfo;
import com.yliao.exception.BusinessException;
import org.apache.ibatis.builder.BuilderException;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 * 用户服务
 */
public interface IUserService {
    /**
     * 注册用户
     * @param userInfo
     * @return
     * @throws BusinessException
     */
    boolean saveUser(UserInfo userInfo) throws BusinessException;

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     * @throws BuilderException
     */
    UserInfo queryUserByID(String userId) throws BuilderException;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     * @throws BuilderException
     */
    UserInfo queryUserByUserName(String userName) throws BuilderException;
    /**
     * 修改用户激活状态
     * @param userId
     * @return
     * @throws BuilderException
     */
    boolean changeUserActivateType(String userId) throws BuilderException;
}
