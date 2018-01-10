package com.yliao.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liaoyao
 * @Date 2018/1/4.
 */
public class Log {
    private static Logger logger = LoggerFactory.getLogger(Log.class);
    private Log() {}

    public static void debug(Class<?> clazz, String msg) {
        logger.debug(msg, clazz.getName(), Thread.currentThread().getId());
    }

    public static void error(Class<?> clazz, String msg) {
        logger.error(msg, clazz.getName(), Thread.currentThread().getId());
    }

    public static void info(Class<?> clazz, String msg) {
        logger.info(msg, clazz.getName(), Thread.currentThread().getId());
    }
}
