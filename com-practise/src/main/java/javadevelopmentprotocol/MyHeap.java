package javadevelopmentprotocol;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-23 17:56
 */
public class MyHeap {
    public static void main(String[] args) throws InterruptedException, ParseException {


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime date1 = LocalDateTime.now();
        System.out.println(formatter.format(date1));
        System.out.println(String.format("时间:%s测试生成堆栈文件!", format));


        Date date4 = simpleDateFormat.parse("123");
        System.out.println(date4.getTime());

        long l = -1;
        System.out.println(l);
    }
}
