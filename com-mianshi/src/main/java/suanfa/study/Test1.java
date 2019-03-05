package suanfa.study;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-05 下午 4:10
 */
public class Test1 {

    public static void main(String[] args) {
        String str = "a bc defg ghi j k l mn op q";
        System.out.println("最大的字符串是:"+maxString(str));

    }

    static String maxString(String str){
        String[] split = str.split("\\s+");
        String maxString = "";
        for (String s : split) {
            if(maxString.length()<s.length()){
                maxString = s;
            }
        }
        return maxString;
    }
}
