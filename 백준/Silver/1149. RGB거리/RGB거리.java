import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int [][]arr = new int[N][3];
        int [][]dp = new int[N][3];
        // dp[i][j] : i번째 집까지 칠했을 때, i번째 집을 j색으로 칠한 최소 비용

        // 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        // DP 점화식
        for(int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        // 결과
        System.out.print(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}