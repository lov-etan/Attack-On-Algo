import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, size, ans;
    static int map[][];
    static boolean isS;
    static boolean visited[][], wasIce[][];
    static Queue<int []> que = new LinkedList<>();
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        // visited = new boolean [n][m];
        wasIce = new boolean [n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a != 0) que.offer(new int [] {i, j});
                map[i][j] = a;
            }
        }
        
        size = que.size();
        if (!find()) isS = bfs();
        
        System.out.println(isS ? ans : 0);
    }

    static boolean bfs() {
        while (!que.isEmpty()) {
            if (size == 0) {
                ans++;
                
                if (find()) return true;
                
                size = que.size();
                wasIce = new boolean [n][m];
            }
            
            int q[] = que.poll();
            size--;
            int r = q[0];
            int c = q[1];

            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dr[d];
                int nc = q[1] + dc[d];

                if (check(nr, nc) && map[nr][nc] == 0 && !wasIce[nr][nc]) {
                    map[r][c]--;
                    if (map[r][c] == 0) {
                        wasIce[r][c] = true;
                        break;
                    }
                }
            }

            if (map[r][c] != 0) que.offer(new int [] {r, c});
        }

        return false;
    }

    static boolean find() {
        int cnt = 0;
        visited = new boolean [n][m];
        for (int ex[] : que) {
            if (!visited[ex[0]][ex[1]]) {
                dfs(ex[0], ex[1]);
                cnt++;
                if (cnt >= 2) return true;
            }
        }
        return false;
    }

    static void dfs(int r, int c) {
        if (visited[r][c]) return;

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (check(nr, nc) && map[nr][nc] != 0) {
                dfs(nr, nc);
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}