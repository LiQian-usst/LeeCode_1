package leecode.tanxin;

public class CanPlaceFlowers {
    // 605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for(int i=0;i<flowerbed.length;i++){
            // 1.首位置
            if(i==0){
                if((i+1<flowerbed.length) && (flowerbed[i]+flowerbed[i+1])==0){
                    flowerbed[i] = 1;
                    res++;
                }else if(flowerbed.length ==1 && flowerbed[i]==0) {
                    flowerbed[i] = 1;
                    res++;
                }
            }else if(i==flowerbed.length-1){
                // 2.末位置
                if((flowerbed[i]+flowerbed[i-1])==0){
                    flowerbed[i] = 1;
                    res++;
                }
            }else {
                // 3.中间位置
                if((flowerbed[i-1]+flowerbed[i]+flowerbed[i+1])==0){
                    flowerbed[i] = 1;
                    res++;
                }
            }
        }
        return res>=n;
    }
}
