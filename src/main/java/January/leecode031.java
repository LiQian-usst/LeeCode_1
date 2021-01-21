package January;

import org.junit.Test;
/**
 * @author qian.li
 * @title: leecode031
 * @description:
 * @date 2021/1/21 19:03
 */
public class leecode031 {
    // 字典序法
    public void nextPermutation(int[] nums) {
        int end = nums.length-2;
        while (end>=0 && nums[end] >= nums[end+1]){
            end--;
        }
        if(end>=0){
            int j = nums.length-1;
            while(j>=0&&nums[j]<=nums[end]){
                j--;
            }
            swap(nums,end,j);
        }
        reverse(nums,end+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    @Test()
    public void test(){
        int[] arr ={1,2,3};
        nextPermutation(arr);
        System.out.println(arr);
    }
}
