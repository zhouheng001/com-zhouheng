package exception;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-04 下午 3:55
 */
public class TestException {

    public static void main(String[] args) {
        try {
            int a = 1/0;
        }catch (Exception e){
            System.out.println("异常");
        }
        System.out.println(123);
    }
}
