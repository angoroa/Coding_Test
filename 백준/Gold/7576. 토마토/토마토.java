import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 열 (x)
        int N = Integer.parseInt(st.nextToken()); // 행 (y)

        int[][] map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        // 입력 + 처음부터 익은 토마토(1)들은 전부 큐에 넣기 (멀티 시작점)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j}); // {y, x}
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                // 범위 밖
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                // 토마토 없는 칸(-1) 또는 이미 익었거나 방문된 칸(0이 아님)은 스킵
                if (map[ny][nx] != 0) continue;

                // 안 익은 토마토(0) -> 익히기 (날짜 +1)
                map[ny][nx] = map[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }

        // 여기서 -1 조건 체크 + 정답 계산
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // BFS 끝났는데도 안 익은 토마토가 남아있으면
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        // 처음 익은 토마토가 1이었으니 "걸린 일수"는 max - 1
        System.out.println(max - 1);
    }
}