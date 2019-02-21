package suanfa.study;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-18 下午 10:11
 */
public class PaiXun {

    public static void main(String[] args) {
        int[] num = {5, 6, 4, 3, 1, 2, 10, 9, 8};
        kuaiPai(num, 0, num.length - 1);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }

    //快速排序
    static void kuaiPai(int[] num, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;

            int midNum = num[i]; //标杆位置

            while (i < j) {
                while (i < j) {
                    if (midNum > num[j]) {
                        num[i] = num[j];
                        break;
                    }
                    j--;
                }
                while (i < j) {
                    if (midNum <= num[i]) {
                        num[j] = num[i];
                        break;
                    }
                    i++;
                }
            }

            num[i]=midNum;
            kuaiPai(num,i+1,end);
            kuaiPai(num,start,i-1);
        }
    }
}
