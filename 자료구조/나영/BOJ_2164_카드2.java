import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] arr;
    static int n, answer;
    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n*2];
        int front = 0;
        int last = n-1;

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        while(front != last) {
            front++;
            arr[++last] = arr[front++];
        }
        
        System.out.println(arr[front]);
    }
}