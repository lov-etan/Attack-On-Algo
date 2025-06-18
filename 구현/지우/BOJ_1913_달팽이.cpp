// 문제풀이 50분 소요 

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int dr[] = {1, 0, -1, 0};
int dc[] = {0, 1, 0, -1};

int main() {
    int N; int k;
    cin >> N >> k;

    vector<vector<int>> arr(N, vector<int>(N, 0));

    int num = pow(N,2);
    int r = 0;
    int c = 0;
    int d = 0;
    pair<int, int> pos = {1,1}; 
    
    arr[r][c] = num;
    num--;

    while(num >= 1) {
        int nxtR = r + dr[d];
        int nxtC = c + dc[d];

        if(nxtR < 0 || nxtR >= N || nxtC < 0 || nxtC >= N || arr[nxtR][nxtC] != 0) {
            // 방향 바꾸기
            d = (d+1)%4;
            nxtR = r + dr[d];
            nxtC = c + dc[d];
        }

        r = nxtR;
        c = nxtC;

        if(num == k) {
            pos = {r+1, c+1};
        }
        
        arr[nxtR][nxtC] = num--;

    }

    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            cout << arr[r][c] << " ";
        }
        cout << "\n";
    }

    cout << pos.first << " " << pos.second;
    
    return 0;
}