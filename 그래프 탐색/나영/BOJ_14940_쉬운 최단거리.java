import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, x, y;
    static int [][] map, ans;
    static int [] dr = {1, 0, -1, 0};
    static int [] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        ans = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }


        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) sb.append(0).append(" ");
                else if (ans[i][j] == 0) sb.append(-1).append(" ");
                else sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static void bfs(int r, int c) {
        Queue<int []> que = new LinkedList<>();
        map[r][c] = 0;
        ans[r][c] = 1;
        que.offer(new int[] {r, c, 1});

        while (!que.isEmpty()) {
            int [] q = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = q[0] + dr[i];
                int nc = q[1] + dc[i];

                if (check(nr, nc)) {
                    if (map[nr][nc] == 1) {
                        ans[nr][nc] = q[2];
                        map[nr][nc] = -1;
                        que.offer(new int[] {nr, nc, q[2] + 1});
                    } else if (map[nr][nc] == 0) ans[nr][nc] = -1;
                }
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
