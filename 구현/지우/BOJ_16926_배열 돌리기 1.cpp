#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N; int M; int R;
vector<vector<int>> arr;
         // 하 우 상 좌 : 반시계!!
int dr[] = {1, 0, -1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int sr, int sc, int er, int ec, int nr, int nc) {
    return nr >= sr && nr < er && nc >= sc && nc < ec;
}

void spin(int box) {
    // 시작점 
    int r = box; int c = box; // 0,0 1,1 2,2
    int val = arr[r][c];
    
    int d = 0;
    for(int i=0; i<2 * ((N - 2 * box) + (M - 2 * box) - 2); i++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(!inRange(box, box, N-box, M-box, nr, nc)) {
            d = (d+1)%4;
        }

        r = r + dr[d];
        c = c + dc[d];
        
        int tmp = arr[r][c];
        arr[r][c] = val;
        val = tmp;
    }
    
}




int main() {
    cin >> N >> M >> R;
    arr.resize(N, vector<int>(M, 0));

    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            cin >> arr[r][c];
        }
    }

    int boxes = min(N,M)/2; // 박스 안의 박스 안의 박스
    for(int i=0; i<R; i++) {
        for(int box=0; box<boxes; box++) {
            spin(box);
        }
    }

    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            cout << arr[r][c] << " ";
        }
        cout << "\n";
    }
    
    return 0;
}