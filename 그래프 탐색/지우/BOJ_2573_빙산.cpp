#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M; 
int currIceberg; int year;
vector<vector<int>> maps; 
queue<vector<int>> q; vector<vector<int>> dp;
queue<vector<int>> q2; vector<vector<bool>> vis;

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}

void checkingBfs() {
    while(!q2.empty()) {
        vector<int> curr = q2.front(); q2.pop();
        int r = curr[0];
        int c = curr[1];
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];

            if(inRange(nr, nc) && !vis[nr][nc] && maps[nr][nc] > 0) {
                vis[nr][nc] = true; 
                q2.push({nr,nc});
            }
        }
    }
}

bool check() {
    vis.assign(N, (vector<bool> (M,false)));
    int cnt = 0;
    
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(!vis[r][c] && maps[r][c] > 0) {
                vis[r][c] = true; q2.push({r,c});
                checkingBfs();
                cnt++;
            }
        }
    }

    if(cnt >= 2) return true;
    return false;
}

void melting() {
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            maps[r][c] = max(maps[r][c] + dp[r][c], 0);
            if(maps[r][c] > 0) {
                q.push({r,c});
            }
        }
    }
}

int bfs() {
    if(check()) return year;
    if(q.size() == 0) return 0;

    int doneIce = q.size();
    dp.assign(N, vector<int>(M,0));
    while(doneIce > 0) {
        vector<int> curr = q.front(); q.pop();
        int r = curr[0];
        int c = curr[1];
        doneIce--;

        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(inRange(nr, nc) && maps[nr][nc] == 0) {
                dp[r][c]--;
            }
        }

    }
    year++;
    melting();

    return bfs();
}

int main() {
    cin >> N >> M;
    maps.resize(N, vector<int>(M));

    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            int in; cin >> in; maps[r][c] = in;
            if(in > 0) {
                q.push({r, c});
                currIceberg++;
            }
        }
    }

    cout << bfs();
    return 0;
}