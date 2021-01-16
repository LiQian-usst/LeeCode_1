package January;

public class leecode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // bookings[i] = [i, j, k] 表示在 i 站上车 k 人，乘坐到 j 站，在 j+1 站下车（i从1开始）
        // 定义counters记录每站的人数变化
        int[] counters = new int[n];
        for(int[] booking:bookings){
            counters[booking[0]-1]+=booking[2];
            if(booking[1] < n){
                counters[booking[1]]-=booking[2];
            }
        }
        for(int i=1;i<counters.length;i++){
            counters[i]+=counters[i-1];
        }
        return counters;
    }
}
