package suanfa;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-02-13 16:44
 */
public class Test {

    public static void main(String[] args) {

        ChangYongSuanFa changYongSuanFa = new ChangYongSuanFa();
        int [] num = new int[]{1,6,4,3,5,2,10,9,8};

        changYongSuanFa.quickSort(num,0,num.length-1);

        for (int i : num) {
            System.out.print(i+" ");
        }

        System.out.println( ChangYongSuanFa.class.getName());
    }
}
