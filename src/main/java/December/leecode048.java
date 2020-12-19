package December;

public class leecode048 {
    /*
    * 给定一个 n × n 的二维矩阵表示一个图像。
    *
    * 将图像顺时针旋转 90 度。
    * */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //1.水平翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //2.沿对角线翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
