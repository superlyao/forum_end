package com.yliao.dao;

import com.yliao.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author liaoyao
 * @Date 2018/1/3.
 */
@Mapper
@Component
public interface IUserDao {
   Object save (UserInfo userInfo);
}
