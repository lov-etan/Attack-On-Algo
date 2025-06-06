import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();
    static char [] charn;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        charn = br.readLine().toCharArray();

        // +, - 는 2, *, / 는 1, ( 는 0
        for (int i = 0; i < charn.length; i++) {
            if(charn[i] >= 'A' && charn[i] <= 'Z') sb.append(charn[i]);
            else if (charn[i] == '+' || charn[i] == '-') {
                // 스택이 비어있지 않으면 괄호 전까지 모두 빼기
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.add(charn[i]);
            } else if (charn[i] == '*' || charn[i] == '/') {
                if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.add(charn[i]);
            } else if (charn[i] == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else stack.add(charn[i]);
        }

        while (!stack.isEmpty()) sb.append(stack.pop());
        
        System.out.println(sb.toString());
    }
}
