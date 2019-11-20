package com.zhouheng.jdk8.lambda.test1;

import com.zhouheng.jdk8.lambda.predict.MySuppley;
import com.zhouheng.jdk8.lambda.vo.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

@Deprecated
public class Test {

    /**
     * 函数式接口分四类
     *
     * @param args 第一种 Consumer<T></>函数  有参无返回值
     *             <p>
     *             第二种 Function<T,R>函数   有参有返回值
     *             <p>
     *             第三种 Supplier<T>函数     无参有返回值
     *             <p>
     *             第四种 Predicate<T>函数    有参返回布尔类型
     *             <p>
     *             新增语法格式
     *             <p>
     *             第一种  类::静态方法名
     *             <p>
     *             第二种  实例对象::方法名
     *             <p>
     *             第三种  类::实例方法名
     */
    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee("jack", 15, 9999.22),
                new Employee("jack1", 17, 8899.22),
                new Employee("jack2", 15, 7799.22),
                new Employee("jack3", 25, 6699.22),
                new Employee("jack4", 65, 2299.22),
                new Employee("jack5", 12, 3399.22));

        List<Employee> collect = list.stream().filter(e -> e.getMoney() > 1000).skip(2).limit(4).collect(Collectors.toList());
        System.out.println(collect);

//        MyComsmer<String> myComsmer= (String name) -> {
//            System.out.println("myComsmer:" + name);
//        };
//
//        myComsmer.test("zhou");
//
//        getA("zhou","123",213);

        collect.forEach(System.out::println);


        MySuppley<Integer> integerMySuppley = collect::size;
//
//        list.stream().filter(e -> e.getAge() > 20).collect(Collectors.toList());

//        MySuppley mySuppley = ()->list.size()>3;
//        mySuppley.get();

        BiPredicate<String,String> biPredicate = (x,y)-> x.equals(y);

        BiPredicate<String,String> biPredicate1 = String::equals;
        biPredicate.test("name","zhou");

        //函数列表要和参数列表一致
        MySuppley<Employee> e = Employee::new;



    }

    public static <R, V, S> void getA(R r, S s, V v) {
        System.out.println(r);
    }
}
