package jiegouxing.bridge;

/**
 * 描述: 电脑
 *
 * @author zhouheng
 * @create 2018-12-16 上午 1:42
 */
public interface Computer {
    void sellComputer();
}

class Desktop implements Computer {
    
    @Override
    public void sellComputer() {
        System.out.println("台式机!");
    }
}

class Laptop implements Computer {
    
    @Override
    public void sellComputer() {
        System.out.println("笔记本!");
    }
}

class Pad implements Computer {
    
    @Override
    public void sellComputer() {
        System.out.println("笔记本!");
    }
}

class DellDesktop extends Desktop {
    @Override
    public void sellComputer() {
        System.out.println("台式机!");
    }
}

class DellLaptop extends Laptop {
    @Override
    public void sellComputer() {
        System.out.println("笔记本!");
    }
}

class DellPad extends Pad {
    @Override
    public void sellComputer() {
        System.out.println("平板电脑!");
    }
}

class LeneveDesktop extends Desktop {
    @Override
    public void sellComputer() {
        System.out.println("台式机!");
    }
}

class LeneveLaptop extends Laptop {
    @Override
    public void sellComputer() {
        System.out.println("笔记本!");
    }
}

class LenevePad extends Pad {
    @Override
    public void sellComputer() {
        System.out.println("平板电脑!");
    }
}