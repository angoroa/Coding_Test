import java.util.*;
import java.io.*;

public class Main {
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }
        // 큐에 좌표를 넣어야 한다.
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int cur[] =q.poll();
            int y = cur[0];
            int x = cur[1];
            for(int i=0; i<4; i++){
                int nx= x + dx[i]; 
                int ny= y + dy[i];
                if (nx<0 || ny<0 || nx>=M || ny >= N) continue;
                // 범위가 아니면
                if (visited[ny][nx]) continue;
                // 방문 했으면
                if (map[ny][nx]== 0) continue;
                // 길이 아니면
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                map[ny][nx] = map[y][x] + 1;
            }
        }
        System.out.println(map[N-1][M-1]);
        
    }
}