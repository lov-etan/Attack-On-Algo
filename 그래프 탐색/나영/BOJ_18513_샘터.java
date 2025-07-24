import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static long ans;
    static Queue<long []> que = new LinkedList<>();
    static Set<Long> set = new HashSet<>();
    static int dr[] = {-1, 1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < n+1; i++) {
            long a = Integer.parseInt(st.nextToken());
            set.add(a);
            que.offer(new long [] {a, 1});
        }

        bfs();
        
        System.out.println(ans);
    }

    static void bfs() {
        while (!que.isEmpty() && k > 0) {
            long [] q = que.poll();

            for (int i : dr) {
                long nr = q[0] + i;
                
                if (!set.contains(nr) && k > 0) {
                    set.add(nr);
                    k--;
                    ans += q[1];
                    que.offer(new long [] {nr, q[1] + 1});
                }
            }
        }
    }
}