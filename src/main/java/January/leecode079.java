package January;

public class leecode079 {
    // 单词搜索
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word,int index, int i, int j,int[][] visited){
        if(index == word.length()){
            return true;
        }else if(0<=i && i<board.length && 0<=j && j<board[0].length && board[i][j]==word.charAt(index)&&visited[i][j]==0){
            visited[i][j]=1;
            // 搜索上下左右四个方位
            if(helper(board,word,index+1,i+1,j,visited) || helper(board,word,index+1,i-1,j,visited)
                    || helper(board,word,index+1,i,j+1,visited) || helper(board,word,index+1,i,j-1,visited)){
                return true;
            }
            // 如果不行，此处需要回溯
            visited[i][j]=0;
            return false;
        }else {
            return false;
        }
    }
}
