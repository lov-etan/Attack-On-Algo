#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n; int m;
int tr; int tc;
vector<vector<int>> maps;
vector<vector<int>> dp;

int dr[] = {1,0,-1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<n && c>=0 && c<m;
}

void bfs(int r, int c) {
    
    queue<vector<int>> q;
    q.push({r,c});

    while(!q.empty()) {
        vector<int> curr = q.front(); q.pop();
        int cr = curr[0];
        int cc = curr[1];

        for(int d=0; d<4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if(inRange(nr, nc) && maps[nr][nc] != 0  && dp[nr][nc] == -1) {
                dp[nr][nc] = dp[cr][cc]+1;
                q.push({nr, nc});
            }
        }
    }

    return;
    
}

int main() {
    cin >> n >> m;
    maps.resize(n, vector<int>(m, 0));
    dp.resize(n, vector<int>(m,-1));

    for(int r=0; r<n; r++) {
        for(int c=0; c<m; c++) {
            int a; cin >> a;
            maps[r][c] = a;
            if(a == 2) {
                tr = r; tc = c;
                dp[r][c] = 0;
            } 
            else if(a == 0) {
                dp[r][c] = 0;
            }
        }
    }

    bfs(tr,tc);

    for(int r=0; r<n; r++) {
        for(int c=0; c<m; c++) {
            cout << dp[r][c] << " ";
        }
        cout << "\n";
    }

    return 0;
}