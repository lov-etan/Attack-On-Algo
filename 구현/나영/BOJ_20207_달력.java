import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, max, ans, x;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int [] arr = new int [367];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        x = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(a <= b) arr[a++]++;
        }

        for (int i = 1; i < 367; i++) {
            if (arr[i] == 0) {
                ans += max * (i - x);
                while(i < 366 && arr[i]==0) i++;
                x = i;
                max = arr[i];
            } else {
                max = Math.max(max, arr[i]);
            }

        }
        
        System.out.println(ans);
        
    }
    
}
