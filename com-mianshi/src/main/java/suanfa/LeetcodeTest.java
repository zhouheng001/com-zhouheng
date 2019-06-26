package suanfa;

public class LeetcodeTest {

	public static void main(String[] args) {

		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		return search(nums, 0, nums.length-1, target);
	}

	private static int search(int[] nums, int l, int r,int target){
		if(l > r){
			return -1;
		}
		int mid = (l+r)/2;
		if(nums[mid] == target){
			return mid;
		}
		if(nums[mid] < nums[r]){
			if(target > nums[mid] && target <= nums[r]){
				return search(nums, mid+1, r, target);
			}else{
				return search(nums, l, mid-1, target);
			}
		}else{
			if(target < nums[mid] && target >= nums[l]){
				return search(nums, l, mid-1, target);
			}else{
				return search(nums, mid+1, r, target);
			}
		}
	}

}
