package December;

public class leecode011 {
    // 盛水最多的容器 两个柱子之间容量计算规则=(j-i)*min(Aj,Ai),其中j>i
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int res=0;
        while(i<j){
            if(res < (j-i)*Math.min(height[i],height[j])){
                res = (j-i)*Math.min(height[i],height[j]);
            }
            if(height[i] > height[j]){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
}
