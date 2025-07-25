import java.util.*;
import java.lang.*;
import java.io.*;

class P {
    int r, c, cnt;
    public P (int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, h, w, s1, s2, f1, f2;
    static int map[][];
    static boolean visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s1 = Integer.parseInt(st.nextToken())-1;
        s2 = Integer.parseInt(st.nextToken())-1;
        f1 = Integer.parseInt(st.nextToken())-1;
        f2 = Integer.parseInt(st.nextToken())-1;
        
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<P> que = new LinkedList<>();
        que.offer(new P(s1, s2, 0));
        visited[s1][s2] = true;

        while(!que.isEmpty()) {
            P p = que.poll();
            if (p.r == f1 && p.c == f2) return p.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (find(d, nr, nc) && !visited[nr][nc]) {
                    que.offer(new P(nr, nc, p.cnt+1));
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    static boolean find(int d, int nr, int nc) {

        if (!check(nr, nc) || !check(nr + h - 1, nc + w - 1)) return false;
        // 위
        if (d == 0) {
            for (int i = 0; i < w; i++) {
                if (map[nr][nc + i] == 1) return false;
            }
        // 아래
        } else if (d == 1) {
            for (int i = 0; i < w; i++) {
                if (map[nr + h - 1][nc + i] == 1) return false;
            }
        // 왼쪽
        } else if (d == 2) {
            for (int i = 0; i < h; i++) {
                if (map[nr + i][nc] == 1) return false;
            }
        // 오른쪽
        } else {
            for (int i = 0; i < h; i++) {
                if (map[nr + i][nc + w - 1] == 1) return false;
            }
        }
        
        return true;
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}