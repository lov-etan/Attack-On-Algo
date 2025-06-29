#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

int N; int d; int k;
vector<vector<int>> arr;
vector<vector<int>> tmp;

void doClock() {
    tmp = arr;
    
    int r=0; int c=0;
    while(r<N && c<N) {
        tmp[r][k] = arr[r][c]; // 주대각선 -> 가운데 세로 
        tmp[r][N-c-1] = arr[c][k]; // 가운데 세로 -> 부대각선
        tmp[k][c] = arr[N-r-1][c]; // 부대각선 -> 가운데 가로 
        tmp[r][c] = arr[k][c]; // 가운데 가로 -> 주대각선
        r++; c++;
    }

    arr = tmp;
    
}

void revClock() {
    tmp = arr;   
    
    int r=0; int c=0;
    while(r<N && c<N) {
        tmp[k][c] = arr[r][c]; // 주대각선 -> 가운데 가로
        tmp[N-r-1][c] = arr[k][c]; // 가운데 가로 -> 부대각선
        tmp[N-r-1][k] = arr[N-r-1][c]; // 부대각선 -> 가운데 세로 
        tmp[r][c] = arr[r][k]; // 가운데 세로 -> 주대각선
        r++; c++;
    }

    arr = tmp;
    
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int T; cin >> T;
    for(int tc=1; tc<=T; tc++) {
        arr.clear(); tmp.clear();
        cin >> N; cin >> d;
        
        arr.resize(N+1, vector<int>(N+1,0));
        tmp.resize(N+1, vector<int>(N+1,0));

        //가운데
        k = (N+1)/2 - 1; 

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                cin >> arr[r][c];
            }
        }

        int dCnt = abs(d)/45; // 45/45 = 1
        while(dCnt > 0) {
            if(d > 0) {
                doClock();
            }
            else if(d < 0) {
                revClock();
            }
            dCnt--;
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                cout << arr[r][c] << " ";
            }
            cout << "\n";
        }
        // cout << "\n";
    }
    
    return 0;
}