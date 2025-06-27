import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, n, d, k;
                    // 우  하 좌 상  하  우 상  좌
    static int [] dr = {0, 1, 0, -1, 1, 0, -1, 0};
    static int [] dc = {1, 0, -1, 0, 0, 1, 0, -1};
    static StringTokenizer st;
    static int [][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()) / 45;

            map = new int [n][n];

            for (int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    map [r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < Math.abs(d); i++) {
                if (d < 0) find(n/2, 4, 0, 0);
                else find(n/2, 0, 0, 0);
            }

            for(int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    sb.append(map[r][c]).append(" ");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb.toString());
        
    }

    static void find(int a, int b, int r, int c) {
        if (a == 0) return;
        k = map [r][c];

        for (int i = b; i < b+4; i++) { 
            for (int j = 0; j < 2; j++) {
                int nr = r + dr[i] * a;
                int nc = c + dc[i] * a;
    
                if (!check(nr, nc)) break;
                int sample = map[nr][nc];
                map[nr][nc] = k;
                k = sample;
                r = nr;
                c = nc;
            }
        }
        find(a-1, b, r+1, c+1);
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    
}
