public class LintCode_115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 0 && f[0][i - 1] == 1){
                f[0][i] = 1;
            }
            else{
                f[0][i] = 0;
            }
        }
        
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0 && f[i - 1][0] == 1){
                f[i][0] = 1;
            }
            else{
                f[i][0] = 0;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                }
                else{
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}