import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static StringTokenizer st;
    static int [] s, d, answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        s = new int [N+1];
        d = new int [N+1];
        answer = new int [N+1];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        while (K > 0) {
            answer = new int [N+1];
            for (int i = 1; i <= N; i++) {
                // answer[i] = s[d[i]];
                answer[d[i]] = s[i];
            }
            s = answer;
            K--;
        }
        
        for (int i = 1; i <= N; i++) {
            sb.append(s[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
