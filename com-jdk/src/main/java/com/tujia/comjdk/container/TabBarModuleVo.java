package com.tujia.comjdk.container;

import lombok.Data;

import java.util.List;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:46
 */
@Data
public class TabBarModuleVo<T extends TabBarVo1> {
    private List<T> items;
}
