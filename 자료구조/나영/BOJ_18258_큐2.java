import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, a, b;
    static Deque<Integer> q = new ArrayDeque<>();
    // static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            char[] chorn = br.readLine().toCharArray();
            String s = "";
            if(chorn[1] == 'u') {
                for (int j = 5; j < chorn.length; j++) {
                    s += chorn[j];
                }
                q.offerFirst(Integer.parseInt(s));
            } else if(chorn[1] == 'o') {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.pollLast()).append("\n");
            } else if(chorn[1] == 'i') {
                sb.append(q.size()).append("\n");
            } else if(chorn[1] == 'm') {
                if (q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(chorn[1] == 'r') {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peekLast()).append("\n");
            } else if(chorn[1] == 'a') {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peekFirst()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}