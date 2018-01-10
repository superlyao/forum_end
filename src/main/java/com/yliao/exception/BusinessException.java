package com.yliao.exception;

/**
 * @author liaoyao
 * @Date 2017/12/27.
 */
public class BusinessException extends Exception {
    /**
     * 异常代码
     */
    private String code="";
    /**
     * 需要登录的异常
     */
    public static final BusinessException ERROR_NEED_LOGIN =new BusinessException("NEED_LOGIN","未登录,或session失效,请登录!");
    /**
     * 无权限的异常
     */
    public static final BusinessException ERROR_NOT_PERMISSION =new BusinessException("NOT_PERMISSION","您无权限操作此功能!");

    private static final long serialVersionUID = 10000L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String code,String msg) {
        super(msg);
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
