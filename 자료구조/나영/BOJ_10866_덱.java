import java.util.*;
import java.lang.*;
import java.io.*;

// 	16504 KB 	124 ms
class Main {
    static Deque<Integer> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();

            if (s.equals("push_front")) q.offerFirst(Integer.parseInt(st.nextToken()));
            else if (s.equals("push_back")) q.offerLast(Integer.parseInt(st.nextToken()));
            else if (s.equals("pop_front")) {
                if (!q.isEmpty()) sb.append(q.pollFirst()).append("\n");
                else sb.append(-1).append("\n");
            } else if (s.equals("pop_back")) {
                if (!q.isEmpty()) sb.append(q.pollLast()).append("\n");
                else sb.append(-1).append("\n");
            } else if (s.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (s.equals("empty")) {
                if (!q.isEmpty()) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            } else if (s.equals("front")) {
                if (!q.isEmpty()) sb.append(q.peekFirst()).append("\n");
                else sb.append(-1).append("\n");
            } else {
                if (!q.isEmpty()) sb.append(q.peekLast()).append("\n");
                else sb.append(-1).append("\n");
            }
            
        }
        
        System.out.println(sb.toString());
    }
}