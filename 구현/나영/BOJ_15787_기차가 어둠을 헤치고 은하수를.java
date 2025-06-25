import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, command, number, seat, ans;
    static boolean [][] train;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean isS;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        train = new boolean[n+1][21];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());

            if (command == 1) {
                seat = Integer.parseInt(st.nextToken());

                train[number][seat] = true;
            } else if (command == 2) {
                seat = Integer.parseInt(st.nextToken());

                train[number][seat] = false;
            } else if (command == 3) {
                if (train[number][20]) train[number][20] = false;
                for (int j = 19; j > 0; j--) {
                    if(train[number][j]) {
                        train[number][j] = false;
                        train[number][j+1] = true;
                    }
                }
            } else {
                if (train[number][1]) train[number][1] = false;
                for (int j = 2; j < 21; j++) {
                    if(train[number][j]) {
                        train[number][j] = false;
                        train[number][j-1] = true;
                    }
                }
            }
        }
        
        // 은하수를 건널 수 있을지 확인
        milkyWay(1);
        
        System.out.println(ans+1);
    }

    static void milkyWay (int t) {
        if (t == n+1) return;

        // boolean isS = false;
        for (int i = 1; i < t; i++) {
            isS = false;
            // 앞에 들어온 열차와 상태가 동일한지 확인
            for (int j = 1; j < 21; j++) {
                if (train[t][j] == train[i][j]) continue;

                // 앞 열차와 동일하지 않으면 isS true로 변경
                isS = true;
                break;
            }

            // 열차 상태 확인 후 isS로 통과 가능한지 확인
            // isS = false면 동일 열차가 존재한다는 의미
            if (!isS) break;
        }

        if (isS) ans++;
        milkyWay(t+1);
    }
}
