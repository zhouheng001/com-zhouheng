package com.tujia.comjdk.Pattern;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-20 上午 12:05
 */
public class Test {

    public static void main(String[] args) {

        Strategy strategy = new StrategyAdd();
        Context context = new Context(strategy);
        int i = context.executeStrategy(2, 4);
        System.out.println(i);
        Strategy strategy1 = new StrategySubstract();
        context = new Context(strategy1);
        int i1 = context.executeStrategy(2, 4);
        System.out.println(i1);

    }
}
