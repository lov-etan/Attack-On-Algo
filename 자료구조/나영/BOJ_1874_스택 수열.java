import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, cur;
    static boolean isS = true;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        cur = 1;
        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            while (cur <= a) {
                stack.add(cur++);
                sb.append("+\n");
            }

            if (stack.peek() == a) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            
        }
        
        System.out.println(sb.toString());
    }
}