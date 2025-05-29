import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> q = new LinkedList<>();
    static int n, k, cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        sb.append("<");
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(n > 0) {
            if (cnt==k-1) {
                if (n==1) {
                    sb.append(q.poll()).append(">");
                    break;
                } else {
                    sb.append(q.poll()).append(", ");
                    cnt = 0;
                    n--;
                    continue;
                }
            }

            q.offer(q.poll());
            cnt++;
            
        }
        
        System.out.println(sb.toString());
    }
}