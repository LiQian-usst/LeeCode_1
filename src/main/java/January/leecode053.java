package January;

/**
 * @author qian.li
 * @title: leecode053
 * @description:
 * @date 2021/1/25 18:55
 */
public class leecode053 {
    // 最大子序和(动态规划解法)
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1]+nums[i]>nums[i] ? dp[i-1]+nums[i] : nums[i];
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
