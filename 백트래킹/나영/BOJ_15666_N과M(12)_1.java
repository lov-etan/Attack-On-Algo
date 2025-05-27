import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static int n, m;
    static Integer [] arr, visited;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new Integer [m];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = set.toArray(new Integer[0]);
        
        Arrays.sort(arr);
        
        find(0, 0);
        
        System.out.println(sb.toString());
    }

    static void find (int c, int cnt) {
        if(cnt == m) {
            for (int i = 0; i < cnt; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = c; i < arr.length; i++) {
            visited[cnt] = arr[i];
            find(i, cnt+1);
        }
    }
}