import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                  bfs(i,j);
                  count++;
                } 
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    static void bfs(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int number = 1;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx<0 || nx > N-1 || ny<0 || ny > N-1) continue;
                if(visited[nx][ny]) continue; 
                if(map[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    number++;
                }
            }
        }
        list.add(number);
        
    }
}