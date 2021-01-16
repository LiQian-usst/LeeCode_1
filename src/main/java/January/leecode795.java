package January;

public class leecode795 {
    // 区间子数组个数
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return getSubArrayAtMostK(A,R) - getSubArrayAtMostK(A,L-1);
    }
    // 找到满足最大值小于等k的子数组个数
    public int getSubArrayAtMostK(int[] nums,int k){
        int res=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=k){
                count++;
            }else {
                count=0;
            }
            res+=count;
        }
        return res;
    }
}
