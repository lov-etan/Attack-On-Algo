import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, ans;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> arr;
    static StringTokenizer st;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) {
            arr.add(new ArrayList<>());
        }
        
        visited = new boolean [n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        find(1);
        
        System.out.println(ans);
    }

    static void find(int c) {
        visited[c] = true;
        for (Integer i : arr.get(c)) {
            if(visited[i]) continue;
            ans++;
            find(i);
        }
    }
}
