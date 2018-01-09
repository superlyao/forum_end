package com.yliao.common;

import java.util.UUID;

/**
 * @Author liaoyao
 * @Date 2018/1/7.
 * 工具类
 */
public class Util {
    /**
     * 图片保存的路径
     */
    public static final String IMAGE_PATH = "/image/userface";

    private static final String NULL = "null";
    /**
     * 工具类私有化构造方法
     */
    private Util() {}

    /**
     * 判断对象是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(String object) {
        if (object == null || "".equals(object.toString()) || NULL.equals(object) || object.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 获取随机id
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * volatile实现基于线程安全
     * 创建mimemessage单例模式
     * @return MimeMessage

    public static MimeMessage getMimeMessage() {
    if (mimeMessage == null) {
    synchronized(Util.class) {
    if (mimeMessage == null) {
    mimeMessage = mailSender.createMimeMessage();
    }
    }
    }
    return mimeMessage;
    }
     */
}
