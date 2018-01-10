package com.yliao.bean.dto;

/**
 * The type Error info.
 *
 * @param <T> the type parameter
 * @author liaoyao
 * @Date 2017 /12/27.
 */
public class ErrorInfo<T> {
    /**
     * The constant SUCCESS.
     */
    public static final Integer SUCCESS = 200;
    /**
     * The constant ERROR.
     */
    public static final Integer ERROR = 100;

    private String message;
    private Integer code;
    private T data;
    private String url;
    private boolean isSuccess;

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
