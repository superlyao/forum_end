package com.bean;

import java.io.Serializable;

/**
 * The type User info.
 * @Author liaoyao
 * @Date 2018 /1/3.
 * 用户前端注册用户类
 */
public class UserInfo implements Serializable {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String userFace;

    /**
     * 性别 男0 女1
     */
    private Integer sex;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets pass word.
     *
     * @return the pass word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Sets pass word.
     *
     * @param passWord the pass word
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user face.
     *
     * @return the user face
     */
    public String getUserFace() {
        return userFace;
    }

    /**
     * Sets user face.
     *
     * @param userFace the user face
     */
    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
