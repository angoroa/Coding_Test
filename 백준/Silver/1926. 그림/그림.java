import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 그림 정보 입력
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();

        // 방향 벡터 (상,하,좌,우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 0;       // 그림 개수
        int maxSize = 0;     // 최대 넓이

        // 모든 칸 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그림 발견
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++; // 그림 개수 증가

                    int size = 1; // 현재 그림 넓이
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            // 범위 내 + 방문 안함 + 값이 1
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    size++;
                                }
                            }
                        }
                    }

                    // 최대 넓이 갱신
                    if (size > maxSize)
                        maxSize = size;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
        System.out.println(maxSize);
    }
}