package exception;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;
import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test {

//    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) throws InterruptedException {
//        int a = -2;
//        System.out.println(a >> 1);
//        CountDownLatch latch = new CountDownLatch(2);
//
//        latch.countDown();
//        latch.await();
        List list = Arrays.asList("123","12","1","232");

        System.out.println(1);

        List<String> imOflist=ImmutableList.of("peida","jerry","harry");
        List<String> immutableList = ImmutableList.copyOf(list);


    }

    public enum Type{
        APP,PC,WX,ALIPAY;
    }
}
