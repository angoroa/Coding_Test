import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        boolean [][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        int n = maps.length -1;
        int m = maps[0].length -1;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 최단거리일 떄 (정답 리턴할 때)인데 내가 nx, ny가 무슨 값이랑 같야아할지 인덱스를 모르겠음
                if((nx >= 0 && nx < maps.length) && (ny >=0 && ny < maps[0].length) && !visited[nx][ny] && maps[nx][ny] == 1){
                    if (nx == n && ny == m) return maps[x][y]+1; 
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }
        // 벽에 가로막혀 있을 떄 
        return -1;
        
    }
}