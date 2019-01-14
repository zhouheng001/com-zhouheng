package com.tujia.comjdk.container;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:48
 */
public class Test {
    public static void main(String[] args) {
        TabBarVo tabBarVo = new TabBarVo("游戏","LOL");
        TabBarVo tabBarVo1 = new TabBarVo("娱乐","唱歌");

        TabBarModuleVo<TabBarVo> tabBarModuleVo = new TabBarModuleVo();
        tabBarModuleVo.setItems(Arrays.asList(tabBarVo,tabBarVo1));
        System.out.println(tabBarModuleVo);
    }
}
