import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = sc.nextInt();
        int max = 4 * (n - 1) + 1;

        // 윗쪽
        for (int i = 0; i < max / 2; i++) {
            if (i%2!=0) {
                int m = max;
                while (m > max - i) {
                    sb.append("* ");
                    m -= 2;
                }

                while (m > i+1) {
                    sb.append(" ");
                    m--;
                }
                
                while (m > 0) {
                    sb.append(" *");
                    m -= 2;
                }
            } else {
                for (int j = 0; j < i/2; j++) {
                    sb.append("* ");
                }
                
                for (int j = 0; j < max - i*2; j++) {
                    sb.append("*");
                }
                
                for (int j = 0; j < i/2; j++) {
                    sb.append(" *");
                }
            }
            sb.append("\n");
        }

        for (int i = 0; i < max; i+=2) {
            if (i == max-1) sb.append("*");
            else sb.append("* ");
        }
        
        sb.append("\n");

        // 아래쪽
        for (int i = max / 2; i > 0; i--) {
            if (i%2==0) {
                int m = max;
                while (m > max - i + 1) {
                    sb.append("* ");
                    m -= 2;
                }

                while (m > i) {
                    sb.append(" ");
                    m--;
                }
                
                while (m > 0) {
                    sb.append(" *");
                    m -= 2;
                }
            } else {
                for (int j = 0; j < i/2; j++) {
                    sb.append("* ");
                }
                
                for (int j = 0; j < max - (i-1)*2; j++) {
                    sb.append("*");
                }
                
                for (int j = 0; j < i/2; j++) {
                    sb.append(" *");
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}