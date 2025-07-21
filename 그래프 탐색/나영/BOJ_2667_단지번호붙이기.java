import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char map[][];
    static List<Integer> list = new ArrayList<>();
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0 ,-1};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == '1') bfs(r, c);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for (int i : list) sb.append(i).append("\n");
        
        System.out.println(sb.toString());
    }

    static void bfs(int r, int c) {
        int cnt = 1;
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {r, c});
        map[r][c] = '0';

        while (!que.isEmpty()) {
            int q[] = que.poll();

            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dr[d];
                int nc = q[1] + dc[d];

                if (check(nr, nc) && map[nr][nc] != '0') {
                    map[nr][nc] = '0';
                    cnt++;
                    que.offer(new int[] {nr, nc});
                }
            }
        }

        list.add(cnt);
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}