import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [][] map, result;
    static char [] charn;
    static List<int []> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
                    //  좌  상  우  하 좌상 우상 좌하 우하
    static int [] dc = {-1, 0 , 1, 0, -1, -1, 1, 1};
    static int [] dr = {0, -1 , 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char [n][];
        result = new char [n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') list.add(new int[] {i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            charn = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (charn[j] == 'x') {
                    // 지뢰인지 확인
                    if (result[i][j] == '*') {
                        // 이미 지뢰 체크 한 상태이면 continue
                        continue;
                    } else if (map[i][j] == '*') {
                        // 지뢰면 모든 지뢰를 *로 표시
                        for (int [] arr : list) {
                            result[arr[0]][arr[1]] = '*';
                        }
                    // 지뢰가 아닌 부분이 열렸다면 주변 지뢰 갯수 체크
                    } else {
                        int cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            int nr = i + dc[k];
                            int nc = j + dr[k];
                            if (check(nr, nc) && map[nr][nc] == '*') cnt++;
                        }
                        result[i][j] = (char) (cnt + '0');
                    }
                } else {
                    // 만약 이미 지뢰로 설정되었으면 continue
                    if (result[i][j] == '*') continue;
                    else result[i][j] = '.';
                }
            }
        }
        
        for (char [] c : result) {
            for (int i = 0; i < n; i++) {
                sb.append(c[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean check(int a, int b) {
        return a >= 0 && a < n && b >= 0 && b < n;
    }
    
}