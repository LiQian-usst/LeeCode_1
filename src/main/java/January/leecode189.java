package January;

public class leecode189 {
    // 旋转数组
    public void rotate(int[] nums, int k) {
        if(nums.length>1){
            if(k>nums.length){
                k = k % nums.length;
            }
            reverse(nums,0,nums.length-k-1);
            reverse(nums,nums.length-k,nums.length-1);
            reverse(nums,0,nums.length-1);
        }
    }
    //转置数组nums从下标start到end的值
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
