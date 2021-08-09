package leecode.dongtaiguihua.bag;

public class BasePack {
    public static void main(String[] args) {
        getValue();
    }
    static int N=6;//物品有五件
    static int W=21;//背包容量为20(数组下标)
    static int weight[]= {0,2,3,4,5,9};//重量2 3 4 5 9
    static int value[]= {0,3,4,5,8,10};//价值3 4 5 8 10
    public static void getValue() {
        //sum[i][j]意思是：背包容量为j时，在前i件物品中取小于等于i件物品，此时取得的物品的价值最大
        int sum[][]= new int[N][W];
        for(int i=1;i<N;i++) {
            for(int j=1;j<W;j++) {
                //太重了，拿不了
                if(weight[i]>j) {
                    sum[i][j]=sum[i-1][j];
                }else {
                    //拿：sum[i-1][j-weight[i]]+value[i]   不拿： sum[i-1][j]
                    //因为sum[i-1][j-weight[i]]可以理解为此时还没拿第i件的最大价值，当然我们要留weight[i]空间
                    sum[i][j]=Math.max(sum[i-1][j-weight[i]]+value[i], sum[i-1][j]);
                }
            }
        }
        System.out.println(sum[5][20]);
    }
}
