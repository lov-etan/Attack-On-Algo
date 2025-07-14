import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, cnt;
    static int [][] arr;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];
        visited = new boolean [n+1];
        visited[0] = true;
        cnt = -1;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b > 0) arr[a][0] = b;
            if (c > 0) arr[a][1] = c;
        }

        dfs(1, 0);
        
        System.out.println(cnt < 0 ? 0 : cnt);
    }

    static void dfs(int v, int k) {
        visited[v] = true;
        sb.append(v).append(" ");
        cnt++;

        for (int i = 0; i < 2; i++) {
            int a = arr[v][i];
            if (visited[a]) continue;

            // 맨 위 루트가 왼쪽인지 오른쪽인지 확인한 뒤
            // 왼쪽이면 해당 i값을, 오른쪽이면 내 i값(왼쪽인지, 오른쪽인지)을 넣음
            // v가 1이면 그냥 지금 i값이 k임
            if (v == 1) {
                k = i;
                dfs(a, k);
            }
            else if (k == 0) dfs(a, k);
            else dfs(a, i);

            // 끝점을 방문했는데, 루트 노드도 오른쪽이고, 내 위 노드도 오른쪽이면 
            // 다시 위로 올라갈 필요가 없음
            if (visited[n] == true && k==1 && i==1) return;
            
            sb.append(v).append(" ");
            cnt++;
        }
    }
}
