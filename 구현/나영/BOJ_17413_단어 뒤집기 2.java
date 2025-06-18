// 소요 시간 27분

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char [] charn;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        charn = sc.nextLine().toCharArray();

        for (int i = 0; i < charn.length; i++) {
            if (charn[i] == '<') {
                while (i < charn.length && charn[i] != '>') {
                    sb.append(charn[i++]);
                }
                sb.append(charn[i]);
            } else if (charn[i] == ' ') {
                sb.append(charn[i]);
            } else {
                int n = i;
                while (i < charn.length && (charn[i] != '<' && charn[i] != ' ')) i++;
                --i;
                for (int j = i; j >= n; j--) {
                    sb.append(charn[j]);
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}