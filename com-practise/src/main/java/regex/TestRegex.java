package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhouheng-os
 * @Date 2019/10/28
 * @Description
 */
public class TestRegex {

    public static void main(String[] args) {

        String regexStr = "^bucket$";
        String regexStr1 = "bucket";
        String r2 = "[a-z]{1,}";
        String r3 = "[A-Z]";
        String r4 ="[a-zA-Z]";
        String r5 = "[0-9]";
        String r6 = "[0-9\\.\\-]";
        String r7 = "[ \\f\\r\\t\\n]";
        String r8 = "^[a-z][0-9]$";
        String r9 = "^[^0-9][0-9]$";
        String r10 = "^[a-zA-Z_]$";
        String r11 = "^[a-zA-Z0-9]{1,}";

        String r12 = "^[.0-9]{1,}E\\+[0-9]{1,}$";

        String pattern = ".*bucket.*";



//        System.out.println("bucket".matches(regexStr1));
//        System.out.println("what is bucket".matches(regexStr1));
//        System.out.println("f".matches(r2));
//        System.out.println("fkjfjdf".matches(r2));
//        System.out.println("fkjfjdf123".matches(r11));
//        System.out.println("F".matches(r3));
//        System.out.println("FF".matches(r3));
//        System.out.println(".".matches(r6));
//        System.out.println("a1".matches(r8));
//        System.out.println("a1".matches(r9));
//
//        System.out.println("d".matches(r10));

       System.out.println("13.23E+10".matches(r12));


//        String str = "what is bucket dfda";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());


//        System.out.println("0001".matches("[0-9]{4}"));
    }

}
