import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer, cnt1, cnt2;
    static char [] charn;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        charn = br.readLine().toCharArray();

        for (int i = 0; i < charn.length; i++) {
            // cnt1, 2로 곱하기 갯수 체크
            if (charn[i] == '(') {
                cnt1++;
                stack.add(charn[i]);
            } else if (charn[i] == '[') {
                cnt2++;
                stack.add(charn[i]);
            } else if (charn[i] == ')') {
                // 스택이 비어있지 않고 짝이 맞는지 확인
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // 곱셈에 사용되었는지 확인
                    if (charn[i-1] == '(') {
                        // 사용되지 않았다면 answer에 알맞은 값 더하기
                        answer += Math.pow(2, cnt1) * Math.pow(3, cnt2);
                    }
                    stack.pop();
                    cnt1--;
                } else {
                    answer = 0;
                    break;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    // 곱셈에 사용되었는지 확인
                    if (charn[i-1] == '[') {
                        // 사용되지 않았다면 answer에 알맞은 값 더하기
                        answer += Math.pow(2, cnt1) * Math.pow(3, cnt2);
                    }
                    stack.pop();
                    cnt2--;
                } else {
                    answer = 0;
                    break;
                }
            }	

        }

        // stack에 남은 괄호가 없는지 확인
        if (stack.size() != 0) answer = 0;
        System.out.println(answer);
        
    }
}
