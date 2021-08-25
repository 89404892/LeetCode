import java.util.Arrays;
/**
* @Author:zzh
* @Date:2021/8/25
* @Des:16. 最接近的三数之和
*/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int length= nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                int sum = nums[i] + nums[j];
                int temp=halfSearch(nums, j + 1, length - 1, target-sum);
                result = closetCompare(sum + nums[temp], result, target)?result:sum + nums[temp];
            }
        }
        return result;
    }

    public boolean closetCompare(int a,int b,int target) {
        return Math.abs(a-target)>Math.abs(b-target)?true:false;
    }
    public int halfSearch(int[] nums,int start,int end,int target) {
        int mid=(start+end)/2;
        if (nums[mid]==target||end-start<=1)return closetCompare(nums[mid],nums[end],target)?end:mid;
        int val =start;
        if (nums[mid] > target) {
            val = halfSearch(nums, start, mid - 1, target);
        } else {
            val=halfSearch(nums, mid+1, end,target);
        }
        return closetCompare(nums[mid],nums[val],target)?val:mid;
    }
}
