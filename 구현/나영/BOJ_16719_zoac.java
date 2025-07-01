import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static char [] charn;
    static boolean [] visited;
    static String input;
    static char tmp;
    static int index, size, cnt;
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) {
        input = sc.next();
        charn = input.toCharArray();
        size = input.length();
        visited = new boolean [charn.length];

        find(0);

        System.out.println(sb2.toString());
    }

    static void find(int n) {
        int cnt = 0;

        while (true) {
            tmp = 'Z' + 1;
            cnt = 0;
            for (int i = n; i < input.length(); i++) {
                if (!visited[i] && input.charAt(i) < tmp) {
                    tmp = input.charAt(i);
                    index = i;
                }
            }
            if (tmp > 'Z') break;
            visited[index] = true;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb2.append(charn[i]);
                    if (i >= n) cnt++;
                }
            }
            sb2.append("\n");
            if (cnt >= charn.length - n) break;
            find(index);
        }
    }
}
