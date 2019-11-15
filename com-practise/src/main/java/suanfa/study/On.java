package suanfa.study;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-04-22 下午 8:54
 */
public class On {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        kuaiPai(nums, 0, nums.length - 1);

        sum(nums,7);

    }


    static void kuaiPai(int[] nums, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end;

            int midNums = nums[start];

            while (left < right) {

                while (left < right) {
                    if (midNums > nums[right]) {
                        nums[left] = nums[right];
                        break;
                    }
                    right--;
                }

                while (left < right) {
                    if (midNums < nums[left]) {
                        nums[right] = nums[left];
                        break;
                    }
                    left++;
                }
            }

            nums[left] = midNums;
            kuaiPai(nums, start, left - 1);
            kuaiPai(nums, left + 1, end);

        }
    }

    static void sum(int[] nums, int sum) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] > sum) {
                right--;
            } else if (nums[left] + nums[right] < sum) {
                left++;
            } else {
                System.out.println(nums[left] + "+" + nums[right] + "=" + sum);
                right--;
                left++;
            }

        }
    }
}
