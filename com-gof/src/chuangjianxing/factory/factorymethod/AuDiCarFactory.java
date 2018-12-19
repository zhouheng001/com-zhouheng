package chuangjianxing.factory.factorymethod;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-25 下午 7:12
 */
public class AuDiCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new AuDi();
    }
}
