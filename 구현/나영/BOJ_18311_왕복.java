// 23:20

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, run, cnt;
    static long k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        arr = new int[n];

        cnt = -1;
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (k != 0) {
            while (true) {
                if (run == n-1 || run == 0) cnt = -cnt;
                k -= arr[run];

                if (run == n-1) k -= arr[run];
                
                if (k < 0) break;
                run += cnt;
            }
        }
        
        System.out.println(run + 1);
    }
}
