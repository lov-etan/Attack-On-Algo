import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, x, y;
    static int [][] map;
                    // 하 우 상 좌
    static int [] dr = {1, 0, -1, 0};
    static int [] dc = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        map[0][0] = n*n;

        if (m == map[0][0]) {
            x = 1;
            y = 1;
        }

        findSnail(0, 0, 0, n*n-1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(x).append(" ").append(y);
        
        System.out.println(sb.toString());
    }

    static void findSnail(int r, int c, int d, int cnt) {
        if (cnt <= 0) return;
        
        int nr = r + dr[d];
        int nc = c + dc[d];
        
        while (check(nr, nc) && map[nr][nc] == 0) {
            if (cnt == m) {
                x = nr+1;
                y = nc+1;
            }
            
            map[nr][nc] = cnt--;
            
            nr += dr[d];
            nc += dc[d];
            
        }
        
        findSnail(nr-dr[d], nc-dc[d], (d+1)%4, cnt);
        
    }

    static boolean check(int a, int b) {
        return a >= 0 && a < n && b >= 0 && b < n;
    }
}