package com.yliao.dao;

import com.yliao.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 */
@Mapper
@Component
public interface IUserDao {
   /**
    * 保存用户
    * @param userInfo
    * @return
    */
   Integer save (UserInfo userInfo);

   /**
    * 根据用户Id查找用户
    * @param userId
    * @return
    */
   UserInfo findById (String userId);

   /**
    * 根据用户名查找用户
    * @param userName
    * @return
    */
   UserInfo findByUserName(String userName);
   /**
    * 修改用户状态
    * @param userId
    * @return
    */
   Integer updateActivate(String userId);
}
