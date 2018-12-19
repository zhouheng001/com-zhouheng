package jiegouxing.bridge;

/**
 * 描述: 品牌
 *
 * @author zhouheng
 * @create 2018-12-16 上午 3:10
 */
public interface Brand {
    void brandName();
}

class Lenovo implements Brand {
    
    @Override
    public void brandName() {
        System.out.println("联想");
    }
}

class Dell implements Brand {

    @Override
    public void brandName() {
        System.out.println("戴尔");
    }
}