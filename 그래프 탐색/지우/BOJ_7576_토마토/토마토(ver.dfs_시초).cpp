// dfs(시초)
#include <iostream>
#include <vector>

using namespace std;

int N, M;
int ripeCnt, unripeCnt;
vector<vector<int>> maps;
vector<vector<bool>> vis;
int ans; int prvCnt;

int dr[] = {-1,0,1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}

void dfs(int cnt, int timeCnt) {
    int minusCnt =0;
    vis.assign(N, vector<bool>(M, false));

    if(cnt == 0) {
        ans = timeCnt;
        return;
    }

    if(prvCnt == cnt) {
        ans = -1;
        return;
    }

    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(!vis[r][c] && maps[r][c] == 1) {
                vis[r][c] = true;
                for(int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(inRange(nr, nc) && !vis[nr][nc] && maps[nr][nc] == 0) {
                        vis[nr][nc] = true;
                        maps[nr][nc] = 1;
                        minusCnt++;
                    }
                }
            }
        }
    }

    prvCnt = cnt;
    dfs(cnt - minusCnt , timeCnt+1);
    return;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> M >> N;
    maps.resize(N, vector<int>(M));

    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            int input; cin >> input;
            maps[r][c] = input;
            if(input == 0) {
                unripeCnt++;
            }
            else if(input == 1) {
                ripeCnt++;
            }
        }
    }

    if(unripeCnt == 0) {
        cout << 0;
        return 0;
    }

    dfs(unripeCnt, 0);
    cout << ans;
    
    return 0;
}