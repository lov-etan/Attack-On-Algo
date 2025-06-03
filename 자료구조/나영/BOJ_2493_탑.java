import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int [] arr;
    static Stack<int []> s1 = new Stack<>();   // 수신받을 탑 목록
    static Stack<int []> s2 = new Stack<>();   // 송신하는 탑 목록
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());

        arr = new int [n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            s1.add(new int [] {Integer.parseInt(st.nextToken()), i});
        }

        while(s1.size()!=1) {
            s2.add(s1.pop());

            // s2가 비어있지 않고 s1.peek()가 크거나 같으면 수신받은 탑
            // s2에 있는 값을 pop하고 해당 인덱스 위치에 s1.peek() **수신받은 탑** 의 인덱스 값을 넣는다
            while (!s2.isEmpty() && s2.peek()[0] <= s1.peek()[0]) {
                arr[s2.pop()[1]] = s1.peek()[1] + 1;
            }
        }

        for (int i = 0; i < n-1; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[n-1]);
        
        System.out.println(sb.toString());
    }
}
