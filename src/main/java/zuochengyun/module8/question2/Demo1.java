package zuochengyun.module8.question2;

import java.util.Scanner;

/**
 * @author qian.li
 * @title: Demo1
 * @description: 未排序数组中累加和为给定值的最长子数组系列问题
 * @date 2021/3/25 18:55
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=scanner.nextInt();
        }
        int res = getMaxLen(arr,target);
        System.out.println(res);
    }

    public static int getMaxLen(int[] arr,int target){
        int len = 0;
        int total;
        for(int i=0;i<arr.length;i++){
            total = 0;
            for(int j=i;j<arr.length;j++){
                total+=arr[j];
                if(total==target){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
}
