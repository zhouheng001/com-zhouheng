package chuangjianxing.factory.factorymethod;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-25 下午 7:15
 */
public class Test {
    public static void main(String[] args) {
        AuDi auDi = (AuDi) new AuDiCarFactory().createCar();
        Biyd biyd = (Biyd) new BiydCarFactory().createCar();
        auDi.run();
        biyd.run();
    }
}
