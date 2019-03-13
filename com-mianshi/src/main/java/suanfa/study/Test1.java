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
        int num = 0;
        int nums = 0;
        int end=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                if(nums < i - num){
                    end = i;
                    nums = i - num;
                }
                num=i;
            }
        }
        int start = end-nums;
        String substring = str.substring(start+1, end);
        System.out.println(substring);

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
