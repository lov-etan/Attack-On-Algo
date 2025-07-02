// 20분 소요

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static char [] charn;
    // static List<Integer> list = new ArrayList<>();
    static boolean isS;
    static Set<Character> set;
    public static void main(String[] args) {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // isS 초기화
            isS = true;

            // set 초기화
            set = new HashSet<>();
            
            // 단어를 char 배열로 받음
            charn = sc.next().toCharArray();

            // list에 중복되지 않고 순서대로 있는 단어를 저장
            // for (int j = 0; j < charn.length; j++) {
            //     if (charn) 
            // }

            /* 단어 처음부터 돌며 
            특정 char가 더 이상 나오지 않으면 다음 char로 넘어감.
            이 때, 넘어간 char가 set에 있는지 확인하고 있으면 그룹 단어가 아니므로 break
            */
            for (int j = 0; j < charn.length; j++) {
                char c = charn[j];
                if (set.contains(c)) {
                    isS = false;
                    break;
                } else {
                    set.add(c);
                    while (j+1 < charn.length && c == charn[j+1]) j++;
                }
            }
            if (isS) ans++;
        }
        System.out.println(ans);
    }
}
