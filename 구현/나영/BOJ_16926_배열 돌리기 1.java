import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, R, tmp1, tmp2, cnt;
    static int [][] map;
                    // 하  우  상  좌
    static int [] dr = {1, 0, -1, 0};
    static int [] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean [][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            visited = new boolean [N][M];
            find(0, 0);
            cnt = 0;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static void find(int r, int c) {
        if (cnt >= N*M) return;
        tmp1 = map[r][c];
        int d = 0;
        int x = r;
        int y = c;
        
        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (check(nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                cnt++;
                tmp2 = map[nr][nc];
                map[nr][nc] = tmp1;
                tmp1 = tmp2;
                r = nr;
                c = nc;
            } else d = (d+1) % 4;
            if (r == x && c == y) break;
        }
        
        find(x + 1, y + 1);
    } 

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
