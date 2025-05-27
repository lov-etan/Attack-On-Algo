import java.util.*;
import java.lang.*;
import java.io.*;

// set 버전 메모리 : 13304 KB, 	88 ms
// 메모리 : 12044 KB,  64 ms
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int [] arr, visited;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n];
        visited = new int [m];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        find(0, 0);
        
        System.out.println(sb.toString());
    }

    static void find (int a, int cnt) {
        if (cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int b = -1;
        for (int i = a; i < n; i++) {
            if (b == arr[i]) continue;
            b = arr[i];
            visited[cnt] = arr[i];
            find(i, cnt+1);
        }
        
    }
}