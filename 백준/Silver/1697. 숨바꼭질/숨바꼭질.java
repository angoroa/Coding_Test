import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K){
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        // 0부터 100000까지니까
        // 0, 1, 2, 3, ... 99999, 100000 : 이 떄는 100000개.
        // 0, 1, 2 = 0<=x<=2 : 이 때는 3개 생각하면 쉽다.
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;
        while(!q.isEmpty()){
            int x = q.poll();

            int next[] = {x-1, x+1, 2*x};
            
            for(int i=0; i < next.length; i++){
                int nx = next[i];
                if (nx<0 || nx>100000) continue; // 범위
                if (visited[nx]) continue; // 방문
                if (nx == K) {
                    System.out.println(dist[x] + 1);
                    return;
                }
                else {
                    dist[nx] = dist[x] + 1;
                    visited[nx] = true;
                    q.offer(nx);
                    
                }
            }
        }
        
        
        
    }
}