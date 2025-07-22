#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int N, M, T; 

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}

int main() {
    cin >> N >> M >> T; int ans = 98765432;

    vector<vector<int>> maps(N,vector<int>(M));
    vector<vector<bool>> vis(N,vector<bool>(M, false));
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            int input; cin >> input;
            maps[r][c] = input;
        }
    }

    queue<vector<int>> q;
    q.push({0,0,0});
    vis[0][0] = true;
    
    while(!q.empty()) {
        vector<int> curr = q.front(); q.pop();
        int r = curr[0]; int c = curr[1];

        if(r == N-1 && c == M-1) {
            ans = min(ans, curr[2]);
        }

        if(maps[r][c] == 2) {
            int to_goal = curr[2] + (N-1-r) + (M-1-c);
            ans = min(ans, to_goal);
        }

        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
      
            if(inRange(nr,nc) && !vis[nr][nc] && maps[nr][nc] != 1) {
                vis[nr][nc] = true;
                q.push({nr,nc, curr[2]+1, curr[3]});
            }
            
        }
    }

    if(ans > 0 && ans <=T) {
        cout << ans;
    } else {
        cout << "Fail";
    }

    return 0;
}