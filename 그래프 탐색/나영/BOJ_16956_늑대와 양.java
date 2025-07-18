import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char [][] map;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char [R][];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        if (!find()) sb.append(0);
        else {
            sb.append(1).append("\n");
            ans();
        }
        
        System.out.println(sb.toString());
    }

    static boolean find() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'S') {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (check(nr, nc)) {
                            if (map[nr][nc] == 'W') return false;
                            else if (map[nr][nc] != 'S')map[nr][nc] = 'D';
                        }
                    }
                }
            }
        }
        return true;
    }

    static void ans() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}