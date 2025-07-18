import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

int M = Integer.parseInt(st.nextToken());
int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());

int[][] map = new int[M][N];

int[][] rects = new int[K][4];

for (int i=0; i<K; i++){
	st = new StringTokenizer(br.readLine());
    	for (int j=0; j<4; j++){
		    rects[i][j] = Integer.parseInt(st.nextToken());       
        }
}
for (int i=0; i<K; i++){
	int x1 = rects[i][0];
    int y1 = rects[i][1];
    int x2 = rects[i][2];
    int y2 = rects[i][3];
    // (0,2) (4,4)
	for(int y=y1; y<y2; y++){
    	for(int x=x1; x<x2; x++){
        	map[y][x] = 1;
        }
    }
    
}
// 상, 하, 좌, 우
int[] dx = {0, 0, -1, 1};
int[] dy = {1, -1, 0, 0};
Queue<int[]>q = new ArrayDeque<>();
List<Integer> areas = new ArrayList<>();
boolean[][] visited = new boolean[M][N];
// q.add(new int[]{0,0});
// visited[0][0] = true;
for (int y=0; y<M; y++){
	for (int x=0; x<N; x++){
    	if(map[y][x] == 0 && !visited[y][x]){
  		int S = 1;
        q.add(new int[]{x,y});
  		visited[y][x]=true;
        while(!q.isEmpty()){
			int start[] = q.poll();
			int curX = start[0];
			int curY = start[1];
                for(int i=0; i<4; i++){						// 이제 상,하,좌,우 탐색
                    int nx = curX + dx[i];				
                    int ny = curY + dy[i];
                    if (nx>=0 && nx<N && ny>=0 && ny<M){	// 범위에 부합하면
                        if(!visited[ny][nx] && map[ny][nx] == 0){
                        visited[ny][nx] = true;
                        S++;
                        q.add(new int[]{nx,ny});				// 큐에 넣는다                   				}
                    
                        }
                    }
                }
        }
		areas.add(S);
      }  
		// 방문했다면 PASS
	}
}
    Collections.sort(areas);
    System.out.println(areas.size());
	for (int a : areas){
    	System.out.print(a+" ");                                                     
    }

 
    }    
}
