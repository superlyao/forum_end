package com.yliao.service.impl;

import com.yliao.bean.UserInfo;
import com.yliao.dao.IUserDao;
import com.yliao.exception.BusinessException;
import com.yliao.service.IUserService;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    @Override
    public boolean saveUser(UserInfo userInfo) throws BusinessException {
        Integer saveResult = iUserDao.save(userInfo);
        return saveResult > 0;
    }

    @Override
    public UserInfo queryUserByID(String userId) throws BuilderException {
        return iUserDao.findById(userId);
    }

    @Override
    public UserInfo queryUserByUserName(String userName) throws BuilderException {
        return iUserDao.findByUserName(userName);
    }

    @Override
    public boolean changeUserActivateType(String userId) throws BuilderException {
        Integer changeActivate = iUserDao.updateActivate(userId);
        return changeActivate > 0;
    }
}
