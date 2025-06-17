import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static char s1, s2;
    static int [] left, right;
    static char [] charn;
    static int ans;
    static Map<Character, int []> map1 = new HashMap<>();
    static Map<Character, int []> map2 = new HashMap<>();
    public static void main(String[] args) {
        // 모든 좌표의 위치 저장
        map1.put('z', new int[] {0, 0});
        map1.put('a', new int[] {0, 1});
        map1.put('q', new int[] {0, 2});
        map1.put('x', new int[] {1, 0});
        map1.put('s', new int[] {1, 1});
        map1.put('w', new int[] {1, 2});
        map1.put('c', new int[] {2, 0});
        map1.put('d', new int[] {2, 1});
        map1.put('e', new int[] {2, 2});
        map1.put('v', new int[] {3, 0});
        map1.put('f', new int[] {3, 1});
        map1.put('r', new int[] {3, 2});
        map1.put('g', new int[] {4, 1});
        map1.put('t', new int[] {4, 2});

        map2.put('b', new int[] {0, 0});
        map2.put('n', new int[] {1, 0});
        map2.put('h', new int[] {1, 1});
        map2.put('y', new int[] {1, 2});
        map2.put('m', new int[] {2, 0});
        map2.put('j', new int[] {2, 1});
        map2.put('u', new int[] {2, 2});
        map2.put('k', new int[] {3, 1});
        map2.put('i', new int[] {3, 2});
        map2.put('l', new int[] {4, 1});
        map2.put('o', new int[] {4, 2});
        map2.put('p', new int[] {5, 2});
        
        s1 = sc.next().charAt(0);
        s2 = sc.next().charAt(0);

        left = map1.get(s1);
        right = map2.get(s2);
        
        charn = sc.next().toCharArray();

        // 왼손/오른손에 따른 좌표 거리 계산 + 키를 누를 때 1을 더해줌
        for (int i = 0; i < charn.length; i++) {
            if (map1.containsKey(charn[i])) {
                int [] arr = map1.get(charn[i]);
                ans += Math.abs(left[0] - arr[0]) + Math.abs(left[1] - arr[1]) + 1;
                left = arr;
            } else {
                int [] arr = map2.get(charn[i]);
                ans += Math.abs(right[0] - arr[0]) + Math.abs(right[1] - arr[1]) + 1;
                right = arr;
            }
        }
        
        System.out.println(ans);
    }
}