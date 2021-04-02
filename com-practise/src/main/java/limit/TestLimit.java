package limit;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-31 上午 10:52
 */
public class TestLimit {
    public static void main(String[] args) {

        for (int i=0;i<10000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CountRateLimiterDemo1.exec();
                }
            }).start();
        }

    }
}
