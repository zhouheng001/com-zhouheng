package com.foo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouheng-os
 * @Date 2019/9/22
 * @Description
 *  定义线程工具类
 */
public class ExecutorsUtils {

    /**
     * 获取线程池
     * @param size
     * @return
     */
    public static ExecutorService getThreadPool(int size){
        return Executors.newFixedThreadPool(size);
    }
}
