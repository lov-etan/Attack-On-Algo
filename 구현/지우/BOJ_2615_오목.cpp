#include <iostream>
#include <vector>

using namespace std;

        // 가로, 세로, 대각선 오른쪽 위, 대각선 오른쪽 아래 - 한 가지 방향으로만 가도록
int dr[] = { 0, 1, 1, -1 };
int dc[] = { 1, 0, 1, 1 };
int arr[19][19];

bool inRange(int r, int c) {
    return r>=0 && r<19 && c>=0 && c<19;
}

bool bingo(int r, int c) {
    for(int d=0; d<4; d++) {
        int cnt = 1;
        int color = arr[r][c];
        
        int nr = r + dr[d];
        int nc = c + dc[d];
        while(inRange(nr, nc) && color == arr[nr][nc]) {
            nr += dr[d];
            nc += dc[d];
            cnt++;
        }

        // 이미 지나온거가 나랑 같은 색이면 안됨
        int passR = r - dr[d];
        int passC = c - dc[d];

        if(cnt == 5 && (!inRange(passR, passC) || arr[passR][passC] != color)) {
            return true;
        } else {
            continue;
        }
    }
    return false;
}

int main() {
    for(int r=0; r<19; r++) {
        for(int c=0; c<19; c++) {
            cin >> arr[r][c];
        }
    }

    for(int r=0; r<19; r++) {
        for(int c=0; c<19; c++) {
            if(arr[r][c] != 0 && bingo(r,c)) {
                cout << arr[r][c] << "\n" << r+1 << " " << c+1 << endl;
                return 0; // 완전 끝
            }
        }
    }

    cout << 0 << "\n"; // 승자x
    return 0;
}