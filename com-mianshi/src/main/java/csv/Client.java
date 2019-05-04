package csv;

import java.util.ArrayList;

/**
 * 描述:
 *  操作客户端
 * @author zhouheng
 * @create 2019-04-23 下午 10:18
 */
public class Client {

    public static void main(String[] args) {

        String filepath = "C:\\Users\\Administrator\\Desktop\\csv\\csv.txt";
        String outpath = "C:\\Users\\Administrator\\Desktop\\csv\\output.txt";
        ArrayList<String> text = CsvUtil.readText(filepath);
        boolean result = CsvUtil.writerText(text, outpath);
        System.out.println("是否生成成功："+ result);
    }
}
