import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] arr;
    static int N, max, min, s;
    public static void main(String[] args) {
        N = sc.nextInt();
        max = 0;
        min = Integer.MAX_VALUE;

        arr = findNums(N);

        // n이 한 자릿수인 경우
        if (arr.length == 1) {
            max = N % 2 == 0 ? 0 : 1;
            min = N % 2 == 0 ? 0 : 1;
        } else find(0, 2, 0, arr, new int [2]);

        System.out.println(min + " " + max);
    }

    static void find(int start, int depth, int sum, int [] nums, int [] index) {
        
        // 만약 3번으로 다 쪼갠 경우
        if (depth <= 0 || nums.length <= 2) {
            int a = 0, b = 0, c = 0;

            // 3구간으로 나뉜 숫자를 구함
            for (int i = 0; i <= index[0]; i++) {
                if (nums[i] % 2 != 0) sum++;
                a = a * 10 + nums[i];
            }

            for (int i = index[0] + 1; i <= index[1]; i++) {
                if (nums[i] % 2 != 0) sum++;
                b = b * 10 + nums[i];
            }
            
            for (int i = index[1] + 1; i < nums.length; i++) {
                if (nums[i] % 2 != 0) sum++;
                c = c * 10 + nums[i];
            }
            
            int d = a + b + c;
            
            if (d < 10) {
                if (d % 2 != 0) sum++;
                max = Math.max(max, sum);
                min = Math.min(min, sum);
                return;
            }
            
            int [] sample = findNums(d);

            find(0, 2, sum, sample, new int[2]);
            return;
        }

        // cnt == 3이 아닐 경우
        for (int i = start; i < nums.length - depth; i++) {
            index[2 - depth] = i;
            find(i+1, depth-1, sum, nums, index);
        }
        
    }

    static int [] findNums (int n) {
        String s = String.valueOf(n);
        int [] sample = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            sample[i] = s.charAt(i) - '0';
        }

        return sample;
    }
}
