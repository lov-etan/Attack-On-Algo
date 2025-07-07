import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int n = sc.nextInt();
        char [] charn = sc.next().toCharArray();

        for (int i = 1; i < n; i++) {
            if (charn[i-1] == 'E' && charn[i] == 'W') ans++;
        }
        
        System.out.println(ans);
    }
}
