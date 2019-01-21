package chuangjianxing.factory.simplefactory;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-22 上午 12:41
 */

public class Test {
    public static void main(String[] args) {
//        Car c1 = new AuDi();
//        Car c2 = new Biyd();

        Car car = new CarFactory().createCar("a");

        car.run();
//        c1.run();
//        c2.run();
    }
}
