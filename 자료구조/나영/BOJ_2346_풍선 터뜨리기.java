import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, a, index;
    static int [] arr;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int [n+1];
        visited = new boolean [n+1];
        visited[1] = true;
        index = 1;
        sb.append(index).append(" ");

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 1번부터 n번까지의 풍선이 있다.
        // 풍선의 번호는 1부터 n까지이고, 풍선의 값은 -1000부터 1000까지이다.
        // 풍선의 값이 양수이면 오른쪽으로, 음수이면 왼쪽으로 이동한다.
        // 따라서 이동할 값이 양수인지 음수인지에 따라 분기하고
        // 이동할 때마다 방문한 풍선은 visited 배열에 true로 표시한다.
        // 이동할 때마다 index를 업데이트하고, a(풍선의 값)는 visited[index]에 따라 ++, -- 한다.
        for (int i = 0; i < n-1; i++) {
            a = arr[index];
            if (a < 0) {
                while(a < 0) {
                    if (index == 1) index = n;
                    else index--;
                    if (visited[index]) continue;
                    a++;
                }
            } else {
                while(a > 0) {
                    if (index == n) index = 1;
                    else index++;
                    if (visited[index]) continue;
                    a--;
                }
            }
            sb.append(index).append(" ");
            visited[index] = true;
        }
        
        System.out.println(sb.toString());
    }
}