import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long dp[][] = new long[n+1][10];
        
        // dp[i][j]: 길이가 i이고, 마지막 숫자가 j인 계단 수 개수
         dp[1][0] = 0;
         dp[1][1] = 1;
         dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = 1;
         dp[1][9] = 1;
        
        // dp[2][0] = dp[1][1]
        // dp[2][1] = dp[1][2]
        // dp[2][2] = dp[2][3] = dp[2][4] = dp[2][5] = dp[2][6] = dp[2][7] = dp[2][8] = 7*2
        // dp[2][9] = 1
        
        // dp[3][0] = dp[2][1]
        // dp[3][1] = dp[2][2] + dp[2][0]
        // dp[3][2] = dp[2][1] + dp[2][3]
        // dp[3][3] = dp[2][2] + dp[2][4]
        // dp[3][4] = dp[2][3] + dp[2][5]
        // dp[3][5] = dp[2][4] + dp[2][6]
        // dp[3][6] = dp[2][5] + dp[2][7]
        // dp[3][7] = dp[2][6] + dp[2][8]
        // dp[3][8] = dp[2][7] + dp[2][9]
        // dp[3][9] = dp[2][8]
        
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1]%1000000000;
                }
                else if(j == 9){
                    dp[i][j] = dp[i-1][8]%1000000000;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }
            }
        }
        long sum = 0;
        for(int i=0; i<=9; i++){
            sum += dp[n][i];
        }
        System.out.print(sum%1000000000);
    }
}
