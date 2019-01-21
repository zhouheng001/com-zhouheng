package chuangjianxing.siglenton;

import java.io.*;

import static chuangjianxing.siglenton.SinglentonEnum.BLUE;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-21 上午 12:54
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SinglentonEnum instance = SinglentonEnum.INSTANCE;
//        SinglentonStaticInnerClass getsinglenton = SinglentonStaticInnerClass.getsinglenton();
//        SingletonHungry singleton = SingletonHungry.getSingleton();
        SinglentonLazy singlenton = SinglentonLazy.getSinglenton();
//        SinglentonDoubleCheck singleton1 = SinglentonDoubleCheck.getSingleton();
//        singlenton.setCount(10);
//        System.out.println(singlenton);
//        SinglentonLazy singlenton1 = SinglentonLazy.getSinglenton();
//        singlenton1.setCount(singlenton1.getCount()+1);
//        System.out.println(singlenton1);
        singlenton.setSinglentonEnum(BLUE);
        SinglentonLazy singlenton1 = SinglentonLazy.getSinglenton();
        SinglentonEnum singlentonEnum = singlenton1.getSinglentonEnum();
        switch (singlentonEnum) {
            case BLUE:
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("错误的类型!");
        }

        FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
        ObjectInputStream outputStream = new ObjectInputStream(fileInputStream);
        SinglentonLazyReflect reflect = (SinglentonLazyReflect) outputStream.readObject();

    }

}
