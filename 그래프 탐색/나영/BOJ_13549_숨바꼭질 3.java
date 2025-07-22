import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, ans;
    static int dp[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int [Math.max(n, k) * 2 + 1];

        Arrays.fill(dp, -1);
        
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        dp[n] = 0;
        que.offer(n);

        while (!que.isEmpty()) {
            int q = que.poll();
            if (q == k) return dp[q];
            
            // 순간이동
            int next = q * 2;
            if (check(next)) {
                dp[next] = dp[q];
                que.offer(next);
            }

            // 뒤로, 앞으로
            for (int i : new int[] {-1, 1}) {
                next = q + i;
                if (check(next)) {
                    dp[next] = dp[q] + 1;
                    que.offer(next);
                }
            }
        }
        
        return -1;
    }
    
    static boolean check(int c) {
        return c >= 0 && c < dp.length && dp[c] == -1;
    }
}