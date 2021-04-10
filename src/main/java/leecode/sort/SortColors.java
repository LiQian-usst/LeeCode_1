package leecode.sort;

public class SortColors {
    // 75. 颜色分类
    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length;
        while(one < two){
            if(nums[one] == 2){
                swap(nums,--two,one);
            }else if(nums[one] == 0) {
                swap(nums,++zero,one++);
            }else {
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
