import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int h, w, max, maxIndex, min, ans;
    static int [] rain;
    public static void main(String[] args) {
        h = sc.nextInt();
        w = sc.nextInt();
        rain = new int [w];
        for (int i = 0; i < w; i++) {
            rain[i] = sc.nextInt();
        }

        // max 설정
        max = rain[0];
        
        // rain 돌기
        for (int i = 1; i < w; i++) {
            min = 0;

            // 빗물의 양을 계산할 때
            if (rain[i-1] < rain[i] && rain[i-1] < max) {
                // 한 값씩 뒤로 가며 계산해야 할 빗물의 양을 조절
                min = i-1;
                for (int j = i-1; j > maxIndex; j--) {
                    int sample = j;

                    while (j > maxIndex && rain[sample] >= rain[j]) j--;

                    // 가로
                    int r = min - j;

                    // 세로
                    int c = Math.min(rain[j] - rain[sample], rain[i] - rain[sample]);
                    ans += r * c;
                    if (rain[i] < rain[j]) break;
                    
                    j++;
                }
            } 
            if (max < rain[i]) {
                max = rain[i];
                maxIndex = i;
            }
        }
        
        System.out.println(ans);
    }
}
