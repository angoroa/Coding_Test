import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[F+1];
        int[] dist = new int[F+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        visited[S] = true;
        dist[S] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if (cur == G){
              System.out.println(dist[cur]);
              return;
            } 
            int curUp = cur+U;
            int curDown = cur-D;
            if (curUp>=1 && curUp <=F && !visited[curUp]){
                q.offer(curUp);
                visited[curUp]=true;
                dist[curUp] = dist[cur] + 1;
            }
            if (curDown>=1 && curDown <=F && !visited[curDown]){
                q.offer(curDown);
                visited[curDown]=true;
                dist[curDown] = dist[cur] + 1;
            }
        }
        System.out.println("use the stairs");
    }
}
