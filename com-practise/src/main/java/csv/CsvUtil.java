package csv;

import java.io.*;
import java.util.ArrayList;

/**
 * 描述:
 * CSV工具类
 *
 * @author zhouheng
 * @create 2019-04-23 下午 10:14
 */
public class CsvUtil {

    /**
     * 对文件进行文本进行读取
     *
     * @param filepath
     * @return
     */
    public static ArrayList<String> readText(String filepath) {
        boolean success = false;
        File csv = new File(filepath);
        csv.setReadable(true);
        csv.setWritable(true);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        String everyLine = "";
        //获取文本内容
        ArrayList<String> allText = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                allText.add(everyLine);
            }
            System.out.println("csv表格中所有行数：" + allText.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return allText;
    }

    public static boolean writerText(ArrayList<String> alltext, String outfile) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(outfile, true);
            bw = new BufferedWriter(fw);
            for (String line : alltext) {
                String[] split = line.split(",");
                String s = line.replaceAll(",", "   ");
                String s1 = s.replaceAll("-", "/");
                bw.write(s1+"\r\n");

            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
