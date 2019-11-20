package com.zhouheng.jdk8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述: api
 *
 * @author zhouheng
 * @create 2018-11-06 下午 11:29
 */
public class TestBigDecial {
    public static void main(String[] args) {
        //
        // BigDecimal的常用方法：
        //     加：add（BigDecima）
        //     减：subtract（BigDecimal）
        // 乘：multiply（BigDecimal）
        // 除：divide（BigDecimal）
        // 乘方：pow（int）
        // 取绝对值：abs（）
        // 取反：negate（）
        // 对比：compareTo（BigDecimal）
        // 设置小数点精确度：setScale（int）
        // 设置保留小数点精确度并添加保留方式（直接加1或者四舍五入）：setScale（int， int）

        // BigDecimal bigDecimal =new BigDecimal(0);
        // for (int i=1;i<5;i++){
        // bigDecimal = bigDecimal.add(new BigDecimal(i));
        // }
        // List list = new ArrayList();
        //
        // System.out.println(bigDecimal);
        // BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(5));
        // System.out.println(divide);
        //
        // BigDecimal subtract = bigDecimal.subtract(BigDecimal.valueOf(3));
        // System.out.println(subtract);
        //
        // BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(5));
        // System.out.println(multiply);
        //
        // BigDecimal pow = bigDecimal.pow(4);
        // System.out.println(pow);
        //
         BigDecimal bigDecimal1 = new BigDecimal(0);
         List<String> s1 = Arrays.asList("1", "2", "3","4", "4", "5","6", "7");
         Stream<Integer> integerStream = s1.stream().map(s -> Integer.parseInt(s));
         System.out.println(integerStream.count());
//         System.out.println(integerStream.reduce(Integer::sum).get());
         Map<Integer, List<Integer>> collect = s1.stream().map(ss ->
         Integer.parseInt(ss)).parallel().collect(Collectors.groupingBy(ss -> ss % 2));
         System.out.println(collect);

        // %s: 字符串类型，如："ljq"
        // %b: 布尔类型，如：true
        // %d: 整数类型(十进制)，如：99
        // %f: 浮点类型，如：99.99
        // %%: 百分比类型，如：％
        // %n: 换行符
        BigDecimal bigDecimal = new BigDecimal(4);
        BigDecimal subtract = bigDecimal.subtract(new BigDecimal(1));
        System.out.println(String.format("4-2=%s", subtract));

    }
}
