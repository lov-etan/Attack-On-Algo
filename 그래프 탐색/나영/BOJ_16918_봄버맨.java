import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, n;
    static char [] charn;
    static int [][] map;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int [R][C];

        for (int r = 0; r < R; r++) {
            charn = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if (charn[c] == 'O') map[r][c] = 1;
            }
        }

        dfs(1);
        
        System.out.println(sb.toString());
    }

    static void dfs(int cnt) {
        if (cnt == n+1 || n == 1) {
            find();
            return;
        }
        
        if (cnt == 2 || (cnt - 3) % 2 != 0) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    map[r][c]++;
                }
            }
        } else {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == 2) {
                        map[r][c] = 0;
                        for (int i = 0; i < 4; i++) {
                            int nr = r + dr[i];
                            int nc = c + dc[i];
        
                            if (check(nr, nc) && map[nr][nc] != 2) map[nr][nc] = 0;
                        }
                    }
                }
            }
        }


        dfs(cnt+1);
    }

    static void find() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0) sb.append('O');
                else sb.append('.');
            }
            sb.append("\n");
        }
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
