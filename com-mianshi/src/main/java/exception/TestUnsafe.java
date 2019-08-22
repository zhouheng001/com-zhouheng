package exception;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-04 下午 3:55
 */
public class TestUnsafe {

     volatile int count = 2;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        try {
//            int a = 1/0;
//        }catch (Exception e){
//            System.out.println("异常");
//        }
//        System.out.println(123);
//        System.out.println(get(1,0));
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put(null,null);

//        HashMap hashMap =new HashMap(7);
//
//        Person person = new Person();
//        person.setName("周恒");
//        person.setValue("12");
//        System.out.println(person.isPerson());
//
//        int addressSize = Unsafe.ADDRESS_SIZE;
//        System.out.println(addressSize);
//        boolean unsafe = new TestUnsafe().get1();
//        System.out.println(unsafe);
        test11(10);
    }

    public static int get(int a,int b){

        try {
            return a/b;
        }catch (Exception e){
            return -1;
        }
    }

    public boolean get1() throws IllegalAccessException, NoSuchFieldException {

        // 获取count域的Field
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // 获取count域的Field
        Class unsafeTestClass = TestUnsafe.class;
        Field fieldCount = unsafeTestClass.getDeclaredField("count");
        fieldCount.setAccessible(true);

        // 计算count的内存偏移量
        long countOffset = (int) unsafe.objectFieldOffset(fieldCount);
        System.out.println(countOffset);

        // 原子性的更新指定偏移量的值（将count的值修改为3）
        boolean b = unsafe.compareAndSwapInt(this, countOffset, count, 3);
        System.out.println("cas:"+b);

        // 获取指定偏移量的int值
        System.out.println(unsafe.getInt(this, countOffset));

        System.out.println(count);
        return true;
    }

    public static void test11(int n){
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;

        n+=1;
        System.out.println(n);
        n-=1;
        System.out.println(n);
        n=-1;
        System.out.println(n);
        n++;
        System.out.println(n);
        ++n;
        System.out.println(n);
    }
}
