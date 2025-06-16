import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int [] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int [n];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 남자일 경우
            if (s == 1) {
                int l = k;
                while (l <= n) {
                    arr[l-1] = arr[l-1] == 0 ? 1 : 0;
                    l += k;
                }
            // 여자일 경우
            } else {
                int a = k-2;
                int b = k;
                arr[k-1] = arr[k-1] == 0 ? 1 : 0;
                while (a >= 0 && b < n) {
                    if (arr[a] == arr[b]) {
                        arr[a] = arr[a--] == 0 ? 1 : 0;
                        arr[b] = arr[b++] == 0 ? 1 : 0;
                    } else break;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if ((i+1) % 20 == 0) sb.append(arr[i]).append("\n");
            else sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}