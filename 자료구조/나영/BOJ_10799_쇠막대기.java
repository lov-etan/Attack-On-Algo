import java.util.*;
import java.lang.*;
import java.io.*;
 
// 메모리 : 14928 KB, 시간 : 112 ms
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [] charn;
    static int answer;
    static char before;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        charn = br.readLine().toCharArray();

        for (int i = 0; i < charn.length; i++) {
            if(charn[i] == '(') {
                stack.add(charn[i]);
            } else {
                stack.pop();
                if(before == '(') {
                    answer += stack.size();
                } else answer++;
            }
            before = charn[i];
        }
        
        System.out.println(answer);
    }
}