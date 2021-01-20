package January;

public class leecode547 {
    // 省份数量 nxn矩阵
    public int findCircleNum(int[][] isConnected) {
        int city = isConnected.length;
        boolean[] visited = new boolean[city];
        int provinces = 0;
        for(int i=0;i<city;i++){
            if(!visited[i]){
                dfs(isConnected,visited,city,i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int city, int i) {
        for(int j=0;j<city;j++){
            if(isConnected[i][j]==1&&!visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,city,j);
            }
        }
    }

}
