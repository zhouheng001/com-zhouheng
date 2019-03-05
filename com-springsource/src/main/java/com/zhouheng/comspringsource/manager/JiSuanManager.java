package com.zhouheng.comspringsource.manager;

import com.zhouheng.comspringsource.annotation.MyAnnotation;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-29 12:06
 */
public class JiSuanManager {

    @MyAnnotation("jisuan")
    public int calculator(int a, int b) {
        return a / b;
    }
}
