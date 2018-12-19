package jiegouxing.composite;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-19 下午 8:39
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f2,f3,f4,f5,f6;
        Folder f1 = new Folder("我的收藏");
        f2 = new ImageFile("头像.jpg");
        f3 = new TextFile("12.txt");

        f1.add(f2);
        f1.add(f3);

//        f2.killVirus();
        f1.killVirus();
    }
}
