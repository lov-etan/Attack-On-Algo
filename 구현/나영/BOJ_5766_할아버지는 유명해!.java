import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, first, second;
    static int [] arr;
    public static void main(String[] args) throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            first = 0;
            second = 0;
    
            if (n == 0 && m == 0) break;

            arr = new int [10001];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int bridge = Integer.parseInt(st.nextToken());
                    ++arr[bridge];
                    if (first != bridge) {
                        if (arr[first] < arr[bridge]) {
                            second = arr[first];
                            first = bridge;
                        } else {
                            second = Math.max(second, arr[bridge]);
                        }

                    } 
                }
            }

            for (int i = 1; i < 10001; i++) {
                if (arr[i] == second) sb.append(i).append(" ");
            }

            sb.append("\n");
            
        }
        
        System.out.println(sb.toString());
    }
}
