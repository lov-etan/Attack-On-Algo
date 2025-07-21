#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N; int M; 
int dr[] = {-1, 0, 1, 0};
int dc[] = {0, -1, 0, 1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}

int main() {
    cin >> N >> M;

    vector<vector<int>> maps(N, vector<int>(M));
    vector<vector<int>> dp(N, vector<int>(M));
    for(int r=0; r<N; r++) {
        string s; cin >> s;
        for(int c=0; c<M; c++) {
            int in; in = s[c]-'0';
            maps[r][c] = in;
        }
    }

    queue<pair<int, int>> q;
    q.push({0,0});
    dp[0][0] = 1;

    while(!q.empty()) {
        pair<int, int> curr = q.front(); q.pop();

        if(curr.first == N-1 && curr.second == M-1) break;

        for(int d=0; d<4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];

            if(inRange(nr, nc) && maps[nr][nc] == 1) {
                maps[nr][nc] = 0;
                dp[nr][nc] = dp[curr.first][curr.second]+1;
                q.push({nr, nc});
            }
        }
    }

    cout << dp[N-1][M-1];
    
    return 0;
}