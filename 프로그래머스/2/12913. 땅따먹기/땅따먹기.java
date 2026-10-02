import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        // dp[i][j] = i행 j열을 밟았을 때 최대 점수
      
        for(int i=0; i<land[0].length; i++){
            dp[0][i] = land[0][i];
        }
        for(int i=1; i< land.length; i++){
                dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
                dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
                dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][3], dp[i-1][1]));
                dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                                                                     }
                                                 
        // dp[i][j] : i행 j열을 밟았을 떄 최대 점수                          
int max =   0;
for(int i=0; i<land[0].length; i++){
    max = Math.max(max, dp[land.length-1][i]);
}                                               
       return max;                                          
    }

    }