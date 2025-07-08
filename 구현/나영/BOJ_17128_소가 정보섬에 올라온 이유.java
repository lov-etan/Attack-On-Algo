import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, q, sum, tmp;
    static int [] cow;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        cow = new int[n];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        tmp = 1;
        
        for (int i = 0; i < 4; i++) tmp *= cow[i];

        sum += tmp;

        for (int i = 4; i < n+3; i++) {
            if (i >= n) tmp = tmp / cow[i-4] * cow[i-n];
            else tmp = tmp / cow[i-4] * cow[i];
            
            sum += tmp;
        }
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(st.nextToken());

            find(a-1);
        }
        
        System.out.println(sb.toString());
    }

    // 해당 값이 들어간 부분만 다시 계산해 sum에 빼고 더함
    static void find(int a) {
        for (int i = 0; i < 4; i++) {
            int s = (a - i + n) % n;
            sum -= cow[s] * cow[(s+1)%n] * cow[(s+2)%n] * cow[(s+3)%n];
        }

        cow[a] = -cow[a];
        
        for (int i = 0; i < 4; i++) {
            int s = (a - i + n) % n;
            sum += cow[s] * cow[(s+1)%n] * cow[(s+2)%n] * cow[(s+3)%n];
        }

        sb.append(sum).append("\n");
    }
}
