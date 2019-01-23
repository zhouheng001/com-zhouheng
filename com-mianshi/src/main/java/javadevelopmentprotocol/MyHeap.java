package javadevelopmentprotocol;

import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-23 17:56
 */
public class MyHeap {
    public static void main(String[] args) throws InterruptedException {

        while (true){

            Date date = new Date();
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM:dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            Thread.sleep(2000);
            System.out.println(String.format("时间:%s测试生成堆栈文件!",format));

        }
    }
}
