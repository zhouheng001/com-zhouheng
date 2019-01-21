package chuangjianxing.factory.simplefactory;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-22 上午 12:43
 */
public class CarFactory {

    public Car createCar(String type) {
        if ("a".equals(type)) {
            return new AuDi();
        } else if ("b".equals(type)) {
            return new Biyd();
        } else {
            return null;
        }
    }

}
