import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static char [] charn;
    static int [] arr = new int [5];
    static StringBuilder s;
    static int ans;
    static boolean isS;
    static boolean [] visited;
    static char [] quack = {'q', 'u', 'a', 'c', 'k'};
    public static void main(String[] args) {
        charn = sc.next().toCharArray();
        visited = new boolean [charn.length];

        while (true) {
            int d = 0;
            isS = false;
            for(int i = 0; i < charn.length; i++) {
                if (!visited[i] && charn[i] == quack[d]) {
                    arr[d] = i;
                    d = (d+1) % 5;
                    if (d == 0) {
                        int m = 0;
                        for (int n : arr) {
                            visited[n] = true;
                        }
                        isS = true;
                    }
                }
            }
            
            if (isS) ans++;
            else {
                for (boolean k : visited) {
                    if (k) continue;
                    ans = -1;
                }
                break;
            }
        }
        
        System.out.println(ans);
    }
}
