import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char [] arr;
    static int [] sample;
    public static void main(String[] args) {
        arr = sc.next().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            n = arr[i] - '0';

            sample = new int[3];
            for (int j = 0; j < 3; j++) {
                sample[j] = n % 2;
                n = n / 2;
            }

            for (int j = 2; j >= 0; j--) {
                if (i == 0) {
                    if (j == 2 && sample[j] == 0) continue;
                    if (j == 1 && sample[2] == 0 && sample[j] == 0) continue;
                }
                sb.append(sample[j]);
            }
        }
        
        System.out.println(sb.toString());
    }
}
