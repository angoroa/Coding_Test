import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int count = 1;
        int[] answer = new int[queries.length];
        // 1. 2차원 배열 초기값 채우기
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = count++;
            }
        }
        // 2, 2, 5, 4,
        // 위: (2,2) -> (4,2)
        // 아래: (2,5) -> (4,5)
        // 왼: (2,2) -> (5,2)
        // 오른: (4,2) -> (4,5)
        
        // 2. 각 쿼리마다 테두리 회전 + 최솟값 기록
        for(int i=0; i< queries.length; i++){
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;
            
            int temp = matrix[r1][c1];
            int min = temp;
            
              // 1. 왼변 (↑): 아래 값을 위로 당기기
  for (int j = r1; j < r2; j++){
      matrix[j][c1] = matrix[j+1][c1];
      min = Math.min(min, matrix[j][c1]);
  }
  // 2. 아랫변 (<-)
  for (int j = c1; j < c2; j++){
      matrix[r2][j] = matrix[r2][j+1];
      min = Math.min(min, matrix[r2][j]);
  }
  // 3. 오른변
  for (int j= r2; j > r1; j--){
      matrix[j][c2] = matrix[j-1][c2];
      min = Math.min(min, matrix[j][c2]);
  }  // 4. 윗변
  for (int j=c2; j>c1; j--){
      matrix[r1][j] = matrix[r1][j-1];
      min = Math.min(min, matrix[r1][j]);     
        }

  
            matrix[r1][c1+1] = temp;
            answer[i] = min;
            
        }
     
        return answer;
    }
}