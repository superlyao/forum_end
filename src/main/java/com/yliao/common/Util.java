package com.yliao.common;

/**
 * @Author liaoyao
 * @Date 2018/1/7.
 * 工具类
 */
public class Util {
    /**
     * 工具类私有化构造方法
     */
    private Util() {}

    /**
     * 判断对象是否为空
     * @param object
     * @return
     */
    public boolean isEmpty(Object object) {
        if (object == null || "".equals(object.toString())) {
            return true;
        }
        return false;
    }
}
