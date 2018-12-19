package jiegouxing.adapter;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 10:23
 */
public class Client {
//   public void test(Target target){
//       target.handleRequest();
//   }

    public static void main(String[] args) {
        Target adapter = new Adapter2(new Adaptee());
        adapter.handleRequest();
    }
}
