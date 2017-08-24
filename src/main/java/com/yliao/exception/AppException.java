package com.yliao.exception;

/**
 * Created by liaoyao on 2017/8/24.
 */
public class AppException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String methodName;
    private String msg;
    private StackTraceElement[] exceptionStack;

    public AppException(String methodName, String msg,
                        StackTraceElement[] exceptionStack) {
        super();
        this.methodName = methodName;
        this.msg = msg;
        this.exceptionStack = exceptionStack;
    }

    public AppException(){}
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public StackTraceElement[] getExceptionStack() {
        return exceptionStack;
    }
    public void setExceptionStack(StackTraceElement[] exceptionStack) {
        this.exceptionStack = exceptionStack;
    }

}
