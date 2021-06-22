package leecode.Search.DFS;

public class FindCircleNum {
    // 547.省份数量
    // 深度优先搜索
    public int findCircleNum(int[][] isConnected) {
        // 城市的个数
        int n = isConnected.length;
        // 记录是否访问过
        int[] visited= new int[n];
        int totalNum = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(isConnected,i,visited);
                totalNum++;
            }
        }
        return totalNum;
    }

    public void dfs(int[][] isConnected,int i,int[] visited){
        // 设置已访问
        visited[i] = 1;
        for(int k=0;k<isConnected.length;k++){
            // 将和当前城市关联且没有被访问过的城市一并被访问
            if(visited[k]==0 && isConnected[i][k]==1){
                dfs(isConnected,k,visited);
            }
        }
    }
}
