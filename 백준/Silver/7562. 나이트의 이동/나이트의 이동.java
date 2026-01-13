import java.io.*;
import java.util.*;
// 4:42 시작
public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int endX;
    static int endY;
    static int l;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++){
            l = Integer.parseInt(br.readLine());
            dist = new int[l][l];
            for (int x=0; x<l; x++){
                for (int y=0; y<l; y++){
                    dist[y][x] = -1;
                }
            }
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            
            int answer = bfs(startX, startY);
            System.out.println(answer);
            
        }                
    }
    static int bfs(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        dist[startY][startX]=0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int dir = 0; dir<8; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx<0|| nx>=l || ny<0 || ny>=l) continue;
                if(dist[ny][nx] != -1) continue;
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{nx, ny});
                    if(nx == endX && ny == endY){
                        return dist[ny][nx];
                    }
                }
            }
        return dist[endY][endX];
    }
}