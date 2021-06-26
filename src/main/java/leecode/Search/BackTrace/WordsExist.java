package leecode.Search.BackTrace;


public class WordsExist {
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;
    // 79.单词搜索
    // 回溯法
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backTrace(board,visited,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(char[][] board,int[][] visited,String word,int curLen,int x,int y){
        if(curLen == word.length()){
            return true;
        }
        if(x<0 || x>=m || y<0 || y>=n || visited[x][y]!=0 || board[x][y]!=word.charAt(curLen)){
            return false;
        }
        visited[x][y]=1;
        for(int[] d:direction){
            if(backTrace(board,visited,word,curLen+1,x+d[0],y+d[1])){
                return true;
            }
        }
        visited[x][y]=0;
        return false;
    }
}
