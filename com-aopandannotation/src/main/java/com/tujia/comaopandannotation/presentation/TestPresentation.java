package com.tujia.comaopandannotation.presentation;

import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-12 下午 11:42
 */
@Component
public class TestPresentation {

    private static int seconds = 3000;

    public int getSeconds() {
        return seconds;
    }

}
