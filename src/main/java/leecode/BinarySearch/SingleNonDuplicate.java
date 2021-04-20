package leecode.BinarySearch;

public class SingleNonDuplicate {
    // 540. 有序数组中的单一元素
    // 每个元素都会出现两次,唯有一个数只会出现一次，找出这个数。
    public int singleNonDuplicate(int[] nums) {
         int start = 0;
         int end = nums.length-1;
         while(start<end){
             int m = start + (end - start)/2;
             if(m%2==1){
                 m--;
             }
             if(nums[m]==nums[m+1]){
                 start = m;
             }else {
                 end = m-2;
             }
         }
         return nums[start];
    }
}
