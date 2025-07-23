import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, h, cnt;
    static int map [][][];
    static int dr[] = {-1, 0 ,1, 0};
    static int dc[] = {0, -1, 0, 1};
    static Queue<int []> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int [h][n][m];

        for (int z = 0; z < h; z++) {
            for (int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < m; c++) {
                    map[z][r][c] = Integer.parseInt(st.nextToken());
                    if (map[z][r][c] == 0) cnt++;
                    else if (map[z][r][c] == 1) que.offer(new int[] {r, c, z});
                }
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {
        int size = que.size();
        int days = 0;

        while (!que.isEmpty()) {
            int q[] = que.poll();
            int r = q[0];
            int c = q[1];
            int z = q[2];
            size--;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (check(nr, nc, z) && map[z][nr][nc] == 0) {
                    map[z][nr][nc] = 1;
                    cnt--;
                    que.offer(new int[] {nr, nc, z});
                }
            }

            if (check(r, c, z-1) && map[z-1][r][c] == 0) {
                map[z-1][r][c] = 1;
                cnt--;
                que.offer(new int[] {r, c, z-1});
            }

            if (check(r, c, z+1) && map[z+1][r][c] == 0) {
                map[z+1][r][c] = 1;
                cnt--;
                que.offer(new int[] {r, c, z+1});
            }
                
            if (size == 0) {
                days++;
                size = que.size();
            }
        }

        return cnt == 0 ? days-1 : -1;
    }

    static boolean check(int r, int c, int z) {
        return r >=0 && r < n && c >= 0 && c < m && z >= 0 && z < h;
    }
}