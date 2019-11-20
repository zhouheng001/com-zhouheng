package stringutils;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-15 下午 9:58
 */
public class TestString {

    public static void main(String[] args) throws IOException {

//        String str = "abdsd";
//        String str1 = "解放军爱丽丝疯狂就";
//        int i = stringToInt(str);
//        System.out.println(i);
//        byte[] bytes = str.getBytes();
//        byte[] bytes1 = str1.getBytes();

//        Socket socketclient = new Socket("localhost",10086);
//        OutputStream outputStream = socketclient.getOutputStream();
//        outputStream.write(bytes);
//        outputStream.flush();
//        outputStream.close();

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.reverse();
//
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.reverse();

//        int a = 4;
//        int i = a >>> 17;
//        System.out.println(i);

//        LocalDateTime localDateTime = LocalDateTime.now();
//        int dayOfMonth = localDateTime.getDayOfMonth();
//        System.out.println(dayOfMonth);
//        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
//        System.out.println(dayOfWeek);
//        String s = dayOfWeekCh(localDateTime);
//        System.out.println(s);
        String date = "2018/09/22";
        String date1 = "2018-09-22";
        int i = date.indexOf("/");
        int i1 = date.indexOf("-");
        int i2 = date1.indexOf("-");
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

        int[] num = new int[5];
        for (int j = 0; j < num.length; j++) {
            System.out.println(num[j]);
        }
    }


    public static int stringToInt(String mun) {
        char[] nums = mun.toCharArray();
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            if (temp > 47 && temp < 58) {
                result += (temp - 48) * Math.pow(10, length - 1 - i);
            }
        }
        return result;
    }

    public static String dayOfWeekCh(LocalDateTime localDateTime) {

        if (localDateTime == null) return "";

        switch (localDateTime.getDayOfWeek()) {

            case MONDAY:
                return "星期一";

            case TUESDAY:
                return "星期二";

            case WEDNESDAY:
                return "星期三";

            case THURSDAY:
                return "星期四";

            case FRIDAY:
                return "星期五";

            case SATURDAY:
                return "星期六";

            default:
                return "星期日";

        }
    }
}