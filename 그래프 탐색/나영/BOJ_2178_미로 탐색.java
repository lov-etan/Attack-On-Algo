import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, ans;
    static char map[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0 ,-1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        System.out.println(bfs(0, 0));
    }

    static int bfs(int r, int c) {
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {r, c, 1});
        map[r][c] = '0';

        while (!que.isEmpty()) {
            int q[] = que.poll();

            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dr[d];
                int nc = q[1] + dc[d];

                if (check(nr, nc) && map[nr][nc] != '0') {
                    map[nr][nc] = '0';
                    if (nr == n-1 && nc == m-1) return q[2] + 1;
                    que.offer(new int[] {nr, nc, q[2] + 1});
                }
            }
        }
        
        return 0;
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}