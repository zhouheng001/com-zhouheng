package com.tujia.com.jdk8.container;

import lombok.Data;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:44
 */
@Data
public class TabBarVo extends TabBarVo1 {
    public TabBarVo(String title, String contidion) {
        this.title = title;
        Contidion = contidion;
    }

    public TabBarVo() {
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 检索条件
     */
    private String Contidion;
}
