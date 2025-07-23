import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, ans;
    static List<Integer> list[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visited = new boolean [n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (ans != 1) dfs(i, 1);
        }
        
        System.out.println(ans);
    }

    static void dfs(int c, int cnt) {
        if (cnt == 5) {
            ans = 1;
            return;
        }
        
        visited[c] = true;

        for (int i : list[c]) {
            if (!visited[i]) {
                dfs(i, cnt + 1);
            }
        }
        
        visited[c] = false;
    }
}