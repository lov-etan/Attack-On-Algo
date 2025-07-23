#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int C, R; int ans;
int unripeCnt;
queue<vector<int>> q;
vector<vector<int>> maps;

int dr[] = {-1,0,1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<R && c>=0 && c<C;
}

int bfs() {
    while(!q.empty()) {
        vector<int> curr = q.front(); q.pop();
        int r = curr[0]; int c = curr[1]; 
        ans = max(ans, maps[r][c]);
        
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(inRange(nr, nc) && maps[nr][nc] == 0) {
                maps[nr][nc] = maps[r][c] + 1;
                unripeCnt--;
                q.push({nr,nc});
            }
        }
    }

    if(unripeCnt == 0) {
        return ans-1;
    } else {
        return -1;
    }
    
}

int main() {
    cin.tie(0); ios::sync_with_stdio(0);
    cin >> C >> R; 
    maps.resize(R, vector<int>(C,0));
    
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {

            int in; cin >> in; maps[r][c] = in;
            if(in == 1) {
                q.push({r,c});
            } else if(in == 0) {
                unripeCnt++;
            }
        }
    }

    if(unripeCnt == 0) {
        cout << 0;
        return 0;
    }

    cout << bfs();
    
    return 0;
}