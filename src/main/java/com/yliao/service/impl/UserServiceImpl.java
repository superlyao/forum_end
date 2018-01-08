package com.yliao.service.impl;

import com.yliao.bean.UserInfo;
import com.yliao.dao.IUserDao;
import com.yliao.exception.BusinessException;
import com.yliao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liaoyao
 * @Date 2018/1/3.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Override
    public boolean saveUser(UserInfo userInfo) throws BusinessException {
        Integer saveResult = (Integer) iUserDao.save(userInfo);
        return saveResult > 0;
    }
}
