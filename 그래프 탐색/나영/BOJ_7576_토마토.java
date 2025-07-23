import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, cnt;
    static int map [][];
    static int dr[] = {-1, 0 ,1, 0};
    static int dc[] = {0, -1, 0, 1};
    static Queue<int []> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 0) cnt++;
                else if (map[r][c] == 1) que.offer(new int[] {r, c});
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {
        int size = que.size();
        int days = 0;

        while (!que.isEmpty()) {
            int q[] = que.poll();
            size--;

            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dr[d];
                int nc = q[1] + dc[d];

                if (check(nr, nc) && map[nr][nc] == 0) {
                    map[nr][nc] = 1;
                    cnt--;
                    que.offer(new int[] {nr, nc});
                }
            }
            
            if (size == 0) {
                days++;
                size = que.size();
            }
        }

        return cnt == 0 ? days-1 : -1;
    }

    static boolean check(int r, int c) {
        return r >=0 && r < n && c >= 0 && c < m;
    }
}