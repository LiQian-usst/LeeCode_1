package leecode.twoPointer;

public class TwoSum {
    // 167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[] res = new int[2];
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                res[0] = start+1;
                res[1] = end+1;
                break;
            }else if(numbers[start]+numbers[end] > target){
                end--;
            }else {
                start++;
            }
        }
        return res;
    }
}
