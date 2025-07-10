import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static ArrayList<Integer> [] list;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        arr = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        
        System.out.println(sb.toString());
    }

    static void bfs(int v) {
        Queue<Integer> que = new LinkedList<>();
        arr[v] = 1;
        que.offer(v);

        while (!que.isEmpty()) {
            int q = que.poll();
            for (int a : list[q]) {
                if (arr[a] == 0) {
                    arr[a] = q;
                    que.offer(a);
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            sb.append(arr[i]).append("\n");
        }
    }
    
}
