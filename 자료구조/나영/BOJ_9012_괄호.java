import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();
    static int T;
    static char[] charn;
    static boolean isS;
    static String result;
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            charn = br.readLine().toCharArray();
            stack = new Stack<>();
            isS = true;
            for (int i = 0; i < charn.length; i++) {
                if (charn[i] == '(') stack.add(charn[i]);
                else if (!stack.isEmpty()) stack.pop();
                else isS = false;
            }
            
            if (!isS || stack.size()!=0) result = "NO";
            else result = "YES";            
            System.out.println(result);
        }
    }
}