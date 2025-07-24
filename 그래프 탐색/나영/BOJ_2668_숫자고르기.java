import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, cnt;
    static int arr[];
    static boolean visited[], finish[];
    static Set<Integer> set = new TreeSet<>();
    static List<Integer> list;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        finish = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            if (!finish[i]) dfs(i);
            if (cnt == i) {
                set.add(i);
                finish[i] = true;
            }
        }

        sb.append(set.size()).append("\n");

        for (int i : set) {
            sb.append(i).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static void dfs(int start) {
        visited[start] = true;
        if (!visited[arr[start]]) dfs(arr[start]);
        else cnt = arr[start];
    }
}