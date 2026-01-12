import java.util.*;
import java.io.*;

public class Main{
    static boolean[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int count = 0;
            map = new boolean[N][M];
            visited = new boolean[N][M];
            for(int j=0; j< K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = true;
            }
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if (!visited[y][x] && map[y][x] == true){
                    BFS(x,y);
                    count++;
                }
            }
        }
            System.out.println(count);
        }
        // int[] cur = queue.poll();
        // int x = cur[0];
        // int y = cur[1];
       
    }
    static void BFS(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
        for (int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= M || ny < 0 || ny >= N){
                continue;
            }
            if(!visited[ny][nx] && map[ny][nx] == true){
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
         
        }

    }
 
}