package zuochengyun.module8.question1;

import java.util.Scanner;
public class Main {
    
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int num = in.nextInt();
         int target = in.nextInt();
         int[] arr = new int[num];
         for(int i=0;i<num;i++){
             arr[i] = in.nextInt();
         }
         if(arr==null || arr.length==0 || target<0){
            System.out.println(0);
         }
         int res = getMaxLen(arr,target);
         System.out.println(res);
     }
     
    public static int getMaxLen(int[] arr,int target){
        // 记录当前满足条件的最大数组长度
        int len = 0;
        int start =0;
        int end =0;
        // 记录arr[start..end]的和
        int sum=arr[0];
        
        while(end<arr.length){
            if(sum==target) {
                if (end - start + 1 > len) {
                    len = end - start + 1;
                }
                sum -= arr[start];
                start++;
            }else if(sum > target){
                sum-=arr[start];
                start++;
            }else{
                end++;
                if(end==arr.length){
                    break;
                }
                sum+=arr[end];
            }
        }
        return len;
    } 
}