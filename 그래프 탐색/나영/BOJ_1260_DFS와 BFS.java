import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, v;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n+1; i++) {
            Collections.sort(list.get(i));
        }

        sb.append(v).append(" ");
        visited[v] = true;
        dfs(v);
        sb.append("\n");
        bfs(v);
        
        System.out.println(sb.toString());
    }

    static void dfs(int v) {
        for (int i = 0; i < list.get(v).size(); i++) {
            int tmp = list.get(v).get(i);
            if (!visited[tmp]) {
                sb.append(tmp).append(" ");
                visited[tmp] = true;
                dfs(tmp);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[n+1];
        visited[v] = true;
        que.add(v);

        while (!que.isEmpty()) {
            int q = que.poll();
            sb.append(q).append(" ");
            for (int i = 0; i < list.get(q).size(); i++) {
                int tmp = list.get(q).get(i);
                if (visited[tmp]) continue;
                visited[tmp] = true;
                que.add(tmp);
            }
        }
    }
}
