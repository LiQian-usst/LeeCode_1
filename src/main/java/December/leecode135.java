package December;

public class leecode135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        //满足从坐到右的分配方案
        for(int i=0;i<len;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        int result = 0;
        int right = 0;
        for(int i=len-1;i>=0;i--){
            if(i<(len-1) && ratings[i] > ratings[i+1]){
                right++;
            }else {
                right = 1;
            }
            //每个人最终分得的糖果数量即为这两个数量的最大值
            result += Math.max(left[i],right);
        }
        return result;
    }
}
