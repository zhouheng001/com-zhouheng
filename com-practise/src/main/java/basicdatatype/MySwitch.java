package basicdatatype;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-06-10 上午 1:22
 */
public class MySwitch {


    public static void main(String[] args) {
        byte b = 1;  //一个字节
        char a = '我';  //两个字节
        int c =1;      //四个字节
        short d =2;    //两个字节
        long e = 3;    //八个字节
        float f = 6.3f;  //四个字节
        double g = 3.45d;  //八个字节
        boolean h = false;   //一个字节
        String i = "dsfadsf";

        double pow = Math.pow(2, 4);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);



        switch (i) {
//            case '他':
//                System.out.println(123);
//                break;
//            case '我':
//                System.out.println(a);
//                break;
            case "dsfadsf":
                System.out.println("dSD");
                break;
            default:
                System.out.println(456);
                break;
        }
    }
}
