package suanfa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-02-13 16:44
 */
public class Test {

   private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

//        ChangYongSuanFa changYongSuanFa = new ChangYongSuanFa();
//        int [] num = new int[]{1,6,4,3,5,2,10,9,8};
//
//        changYongSuanFa.quickSort(num,0,num.length-1);
//
//        for (int i : num) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//
//        int i = changYongSuanFa.binarySearch(num, 0, num.length - 1, 3);
//        System.out.println("位置:"+(i+1));
//
//        System.out.println( ChangYongSuanFa.class.getName());

//        get(1);
//        get(3);
//        get(3);
//        get(2);
//        System.out.println(list);
        for (int i = 0; i <10 ; i++) {
            System.out.println(getNum(i));
        }
    }

    public static List<Integer> get(int a){
        list.add(a);
        list.sort(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1.intValue()-o2.intValue();
           }
        });
        return list;
    }

    public static int getNum(int b){ return b==1||b==0?1:getNum(b-1)+getNum(b-2);}
}
