// DFS : 완탐이라 시간초과
class Solution {
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    static boolean [][] visited;
    static int n, m, answer;
    public int solution(int[][] maps) {
        answer = 10000;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean [n][m];
        
        dfs(0, 0, 0, maps);
        
        return answer == 10000 ? -1 : answer;
    }
    
    static void dfs(int r, int c, int cnt, int[][] maps) {
        if (r == n-1 && c == m-1) {
            answer = Math.min(answer, cnt + 1);
            return;
        }
        
        visited[r][c] = true;
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (check(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                dfs(nr, nc, cnt + 1, maps);
            }
        }
        visited[r][c] = false;
        
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

// BFS
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // static Queue<Integer> que = new Queue<>();
    static boolean [][] visited;
    static int n, m, answer;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        answer = -1;
        n = maps.length;
        m = maps[0].length;
        
        bfs(0, 0, maps);
        
        return answer;
    }
    
    static void bfs(int r, int c, int[][] maps) {
        maps[r][c] = 0;
        Queue<int []> que = new LinkedList<>();
        que.add(new int[] {r, c, 0});
        while (!que.isEmpty()) {
            int [] q = que.poll();
            if (q[0] == n-1 && q[1] == m-1) {
                answer = q[2] + 1;
                return;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dr[d];
                int nc = q[1] + dc[d];

                if (check(nr, nc) && maps[nr][nc] != 0) {
                    maps[nr][nc] = 0;         
                    que.add(new int[] {nr, nc, q[2] + 1});
                }
            }
        }
    }
        
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
