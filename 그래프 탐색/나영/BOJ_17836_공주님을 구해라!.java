import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [][] map;
    static boolean [][][] dp;
    static int n, m, T, ans;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        dp = new boolean [n][m][2];


        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans = bfs();
        
        System.out.println(ans == -1 ? "Fail" : ans);
    }

    static int bfs() {
        Queue<int []> que = new LinkedList<>();
        que.offer(new int [] {0, 0, 0, 0}); 
        while (!que.isEmpty()) {
            int q[] = que.poll();
            
            int r = q[0];
            int c = q[1];
            int cnt = q[2];
            int gram = q[3];

            if (cnt > T) return -1;
            if (r == n-1 && c == m-1) return cnt;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (check(nr, nc) && !dp[nr][nc][gram]) {
                    dp[nr][nc][gram] = true;
                    if (map[nr][nc] == 2) {
                        que.offer(new int [] {nr, nc, cnt+1, 1});
                    } else if (map[nr][nc] <= gram) {
                        que.offer(new int [] {nr, nc, cnt+1, gram});
                    }
                }
            }
        }

        return -1;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}