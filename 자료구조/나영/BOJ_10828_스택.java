import java.util.*;
import java.lang.*;
import java.io.*;


// switch : 	17108KB	328ms
// if-else : 	17268KB	260ms	
class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            
            switch (s) {
                case "push":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(!stack.isEmpty()) System.out.println(0);
                    else System.out.println(1);
                    break;
                case "top":
                    if(!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println(-1);
                    break;
            }
        }
    }

}