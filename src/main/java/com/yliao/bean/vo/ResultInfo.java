package com.yliao.bean.vo;

import java.io.Serializable;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 */
public class ResultInfo<T> implements Serializable {
    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 消息
     */
    private String message;

    /**
     * 附带信息
     */
    private T date;

    public ResultInfo() {}

    public ResultInfo(boolean isSuccess, String message, T date) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.date = date;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
