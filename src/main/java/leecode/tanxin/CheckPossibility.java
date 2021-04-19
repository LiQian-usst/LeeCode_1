package leecode.tanxin;

public class CheckPossibility {
    // 665. 非递减数列
    // 关键点是：nums[i] = nums[i-1] 还是：nums[i-1] = nums[i];
    public boolean checkPossibility(int[] nums) {
        int change = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[i-1]){
                continue;
            }
            if(change==1){
                if(i-2>=0 && nums[i-2] > nums[i]){
                    nums[i] = nums[i-1];
                }else {
                    nums[i-1] = nums[i];
                }
                change--;
            }else {
                return false;
            }
        }
        return true;
    }
}
