package leecode.BinarySearch;

import org.junit.Test;

public class SearchRange {
    // 34.
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length-1;
        int pre;
        int last;
        // 找第一次出现的index
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=target){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        pre = start;
        start = 0;
        end = nums.length-1;
        // 找最后一次出现的index
        while(start < end){
            int mid = start + (end-start+1)/2;
            if(nums[mid]<=target){
                start = mid;
            }else {
                end = mid-1;
            }
        }
        last = start;
        if(nums[pre]==target){
            return new int[]{pre,Math.max(pre,last)};
        }else {
            return new int[]{-1,-1};
        }
    }

    @Test
    public void test(){
        int[] arr = {5,7,7,8,8,10};
        searchRange(arr,8);
    }
}
