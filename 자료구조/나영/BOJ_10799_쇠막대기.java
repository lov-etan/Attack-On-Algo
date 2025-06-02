import java.util.*;
import java.lang.*;
import java.io.*;

// Stack ver - 메모리 : 14928 KB, 시간 : 112 ms
// Count ver - 메모리 : 14184 KB, 시간 : 88 ms
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [] charn;
    static int answer, cnt;
    static char before;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        charn = br.readLine().toCharArray();

        for (int i = 0; i < charn.length; i++) {
            if(charn[i] == '(') {
                cnt++;
            } else {
                cnt--;
                if(before == '(') {
                    answer += cnt;
                } else answer++;
            }
            before = charn[i];
        }
        
        System.out.println(answer);
    }
}