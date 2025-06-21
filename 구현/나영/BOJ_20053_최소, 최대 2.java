import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int T, n, a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                a = Integer.parseInt(st.nextToken());
                if (a > max) max = a;
                if (a < min) min = a;
            }
            if (t != T-1) sb.append(min).append(" ").append(max).append("\n");
            else sb.append(min).append(" ").append(max);
        }        
        System.out.println(sb.toString());
    }
}