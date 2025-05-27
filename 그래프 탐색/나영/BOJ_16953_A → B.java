import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int a, b, result;
    public static void main(String[] args) {
        a = sc.nextInt();
        b = sc.nextInt();

        find(b, 1);
        
        System.out.println(result);
    }

    static void find(int n, int cnt) {
        if (a > n) {
            result = -1;
            return;
        }
        if (a == n) {
            result = cnt;
            return;
        }
        if (n % 2 == 0) {
            find(n/2, cnt + 1);
        } else if ((n-1) % 10 == 0){
            find((n-1) / 10, cnt + 1);
        } else {
            result = -1;
            return;
        }
    }
}