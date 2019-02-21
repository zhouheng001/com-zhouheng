package suanfa.study;

import java.io.File;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-18 下午 7:05
 */
public class Test {


    public static void main(String[] args) {

        // feibonaqie 斐波那切数列
        //1、实现
//        int i = xunHuan(6);
//        System.out.println(i);
        //递归
        int i1 = diGui(6);
        System.out.println(i1);
//
//        c(10);
        //递归文件
//        diGuiFile(new File("F:\\英雄时刻"));

    }


    /**
     * for循环实现
     **/
    static int xunHuan(int num) {

        int num1 = 1;
        int num2 = 1;
        int num3 = 1;

        if (num == 1 || num == 2) {
            return num3;
        }

        for (int i = 3; i <= num; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }

    /**
     * 递归实现
     */
    static int diGui(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return diGui(num - 1) + diGui(num - 2);
    }

    static void diGuiFile(File file) {

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println(file1.getName());
            } else {
                diGuiFile(file1);
            }
        }

    }

    static void c(int a) {
        if (a == 5) {
            System.out.println(a);
        } else {
            a--;
            c(a);
        }

    }

}