package leecode.sort;

public class FastSort {
    // 快速排序 时间复杂度nlogn,空间复杂度logn
    /*该方法的基本思想是：
        1．先从数列中取出一个数作为基准数。
        2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
        3．再对左右区间重复第二步，直到各区间只有一个数。*/
    public static void quickSort(int[] array,int left,int right){
        //快速排序
        int i = left;
        int j = right;
        // 取出基数
        int point = array[left];
        while(i<j){
            // 先后往前找第一个小于point的数
            while(i<j && array[j]>=point){
                j--;
            }
            if(i<j){
                array[i] = array[j];
                i++;
            }
            // 从前往后
            while(i<j && array[i]<=point){
                i++;
            }
            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        // 此时第一轮结束（i==j），需要把point放到当前i和j相会的位置(一个坑)
        array[i]=point;
        if(i-1>left){
            quickSort(array,left,i-1);
        }
        if(i+1<right){
            quickSort(array,i+1,right);
        }
    }

    public static void quickSort2(int[] array,int left,int right){
        int i = left;
        int j = right;
        int point = array[left];
        // i==j时找到了point的位置则退出循环
        while(i<j){
            while(i<j && array[j]>=point){
                j--;
            }
            if(i<j){
                array[i] = array[j];
                i++;
            }
            while(i<j && array[i]<=point){
                i++;
            }
            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = point;
        if(i-1 > left){
            quickSort(array,left,i-1);
        }
        if(i+1 < right){
            quickSort(array,i+1,right);
        }
    }
}
