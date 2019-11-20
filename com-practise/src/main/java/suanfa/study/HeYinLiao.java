package suanfa.study;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-16 上午 1:29
 */
public class HeYinLiao {

    public static void main(String[] args) {

        int i = heYinLiao(10);
        System.out.println(i);

        String s = "asdjfksdjf";
        char getfirst = getfirst(s);
        System.out.println(getfirst);
    }

    static int heYinLiao(int num) {

        if (num == 0) {
            return 0;
        }

        if (num == 1 ) {
            return 1;
        }

        return heYinLiao(num / 2 + num % 2) + (num-num%2);
    }

    static char getfirst(String str){
        int min = str.length();
        for (char ch='a';ch<='z';ch++) {
            int start = str.indexOf(ch);
            int end = str.lastIndexOf(ch);
            if(start!=-1 && start==end){
                if(start<min){
                    min = start;
                }
            }
        }
        return str.charAt(min);
    }
}
