import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int [][] map = new int [5][5];
    static StringBuilder sb = new StringBuilder();
                    //  좌  우  상  하 좌상 우하 좌하 우상
    static int [] dr = {0, 0, -1 , 1, -1, 1, 1, -1};
    static int [] dc = {-1, 1, 0 , 0, -1, 1, -1, 1};
    static int ans;
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        root1 : for (int t = 0; t < 25; t++) {
            int n = sc.nextInt();

            root2 : for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == n) {
                        map[i][j] = 0;

                        int cnt = 0;
                        for (int r = 0; r < 8; r++) {
                            for (int y = 1; y < 5; y++) {
                                int nr = i + dr[r] * y;
                                int nc = j + dc[r] * y;

                                if (!check(nr, nc) || map[nr][nc] != 0) break;
                                cnt++;
                            }
                            if (r % 2 != 0) {
                                if (cnt == 4) {
                                    ans++;
                                }
                                cnt = 0;
                            }
                        }
                        
                        break root2;
                    }
                }
            }
                
            if (ans >= 3) {
                System.out.println(t+1);
                break root1;
            }
        }
        
    }
    
    static boolean check(int a, int b) {
        return a >= 0 && a < 5 && b >= 0 && b < 5;
    }
    
}