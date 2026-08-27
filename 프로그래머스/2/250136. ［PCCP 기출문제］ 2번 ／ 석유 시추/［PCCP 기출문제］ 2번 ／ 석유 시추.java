import java.util.*;
class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int solution(int[][] land) {
        
        int m = land.length; // 행
        int n = land[0].length; // 열 

        boolean visited[][] = new boolean[m][n];
                            int[] oil = new int[n];
        for(int i=0; i<m; i++){ //     행 순회
            for(int j=0; j<n; j++){// 열 순회
                if(!visited[i][j] && land[i][j] == 1){
                    Set<Integer> columns = new HashSet<>();

                    int count = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    
                    while(!q.isEmpty()){
                        int xy[] = q.poll();
                        int x = xy[0];
                        int y = xy[1];
                        count++;
                        columns.add(y);
                        
                        for(int d=0; d<4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx >=0 && nx < m && ny >=0 && ny < n && !visited[nx][ny] && land[nx][ny] == 1){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx,ny});
                                
                            }
                        
                        }
                        
                        
                    }

                    
                    for (int col : columns){
                        oil[col] += count;
                    }
                    
                    
                    
                }
            }
        }
        int answer = 0;
        for(int o : oil){
            answer = Math.max(answer, o);
        }
        return answer;
    }
}