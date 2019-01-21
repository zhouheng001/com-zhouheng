package jiegouxing.bridge;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-16 上午 3:14
 */
public class Computer2 {
    
    protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }
    
    public void sell() {
        brand.brandName();
    }
}

class Desktop2 extends Computer2 {
    
    public Desktop2(Brand brand) {
        super(brand);
    }
    
    @Override
    public void sell() {
        System.out.print("卖台式");
        brand.brandName();
    }
}

class Laptop2 extends Computer2 {
    
    public Laptop2(Brand brand) {
        super(brand);
    }
    
    @Override
    public void sell() {
        System.out.print("卖笔记本");
        brand.brandName();
    }
}
