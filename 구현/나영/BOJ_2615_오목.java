import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int [][] map = new int [20][20];
                    //  하 우 하좌 하우
    static int [] dr = {1, 0, 1, 1};
    static int [] dc = {0, 1, -1, 1};
    static boolean isS;
    static int cnt, num, x, y;
    public static void main(String[] args) {

        // 값 받기
        for (int r = 1; r < 20; r++) {
            for (int c = 1; c < 20; c++) {
                map [r][c] = sc.nextInt();
            }
        }

        // 승부 확인
        r : for (int r = 1; r < 20; r++) {
            for (int c = 1; c < 20; c++) {
                if (map [r][c] != 0) {
                    // 승부 확인
                    for (int d = 0; d < 4; d++) {
                        int nr = r;
                        int nc = c;
                        cnt = 1;

                        // 위에 동일한 값이 있는지 확인
                        if (check(nr - dr[d], nc - dc[d]) && map[nr - dr[d]][nc - dc[d]] == map[r][c]) continue;
                        for (int i = 1; i < 6; i++) {
                            nr += dr[d];
                            nc += dc[d];
                            
                            if (check(nr, nc) && map[nr][nc] == map[r][c]) cnt++;
                            else break;
                        }
                        
                        if (cnt == 5) {
                            num = map [r][c];
                            if (d == 2) {
                                x = nr - dr[d];
                                y = nc - dc[d];
                            } else {
                                x = r;
                                y = c;
                            }
                            break r;
                        }
                    }
                }
            }
        }
        
        System.out.println(num);
        if (num != 0) {
            System.out.println(x + " " + y);
        }
    }

    static boolean check (int r, int c) {
        return r >= 1 && r < 20 && c >= 1 && c < 20;
    }
}
