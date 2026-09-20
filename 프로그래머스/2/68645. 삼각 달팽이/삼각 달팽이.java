import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int r = 0, c = 0;
        
        int size = n;
        while(num <= n*(n+1)/2){
                for (int i=0; i<size; i++){
                    triangle[r][c] = num++;
                    if(i <size-1)r++;
                }
                for (int i=0; i<size-1; i++){
                    c++;                    
                    triangle[r][c] = num++;

                }
                for (int i=0; i<size-2; i++){
                    r--;
                    c--;
                    triangle[r][c] = num++;
                }
                r++;
                size -= 3;

        }
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;

        
    }
}