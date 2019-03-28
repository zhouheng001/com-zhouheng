package suanfa;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-07 下午 6:27
 */
public class ChaZhaoSuanFa {

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 52, 4, 10, 4, 2};
        int i = binSearch1(nums, 4, 0, nums.length);
        System.out.println(i);
    }


    /**
     * @param array 操作数组
     * @param key   查找元素
     * @param start 开始下标
     * @param end   结束下标
     * @return 元素下标
     */
    public static int binSearch1(int[] array, int key, int start, int end) {

        int mid = (end - start) / 2 + start;

        if (key == array[mid]) {
            return mid;
        } else if (key > array[mid]) {
            return binSearch1(array, key, mid + 1, end);
        } else if (key < array[mid]) {
            return binSearch1(array, key, start, mid - 1);
        } else {
            return -1;
        }
    }

}
