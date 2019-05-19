package com.tujia.comjdk.container;

import com.tujia.comjdk.collection.MyCollections;

import java.util.ArrayList;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:48
 */
public class Test {

    public final static MyCollections out = new MyCollections();

    public static void main(String[] args) {
//        TabBarVo tabBarVo = new TabBarVo("游戏", "LOL");
//        TabBarVo tabBarVo1 = new TabBarVo("娱乐", "唱歌");
//
//        TabBarModuleVo<TabBarVo> tabBarModuleVo = new TabBarModuleVo();
//        tabBarModuleVo.setItems(Arrays.asList(tabBarVo, tabBarVo1));
//        System.out.println(tabBarModuleVo);
        Test.out.println(new ArrayList<>());
    }
}
