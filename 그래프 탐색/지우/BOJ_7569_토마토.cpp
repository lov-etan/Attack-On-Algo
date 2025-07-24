#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int R, C, H; int ans;
vector<vector<vector<int>>> maps;
queue<vector<int>> q;

int dr[] = {-1, 0, 1, 0, 0, 0};
int dc[] = {0, 1, 0, -1, 0, 0};
int dh[] = {0, 0, 0, 0, -1, 1};

bool inRange(int r, int c, int h) {
    return r>=0 && r<R && c>=0 && c<C && h>=0 && h<H;
}

void bfs() {
    while(!q.empty()) {
        vector<int> curr = q.front(); q.pop();
        int r = curr[0];
        int c = curr[1];
        int h = curr[2];
        
        for(int d=0; d<6; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            int nh = h + dh[d];

            if(inRange(nr, nc, nh) && maps[nr][nc][nh] == 0) {
                q.push({nr,nc,nh});
                maps[nr][nc][nh] = maps[r][c][h] + 1;
            }
        }
    }
    return;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);;

    cin >> C >> R >> H; 
    int unripe = 0;
    maps.resize(R, vector<vector<int>>(C, vector<int>(H,0)));

    for(int h=0; h<H; h++) {
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                int input; cin >> input;
                maps[r][c][h] = input;

                if(input == 1) {
                    q.push({r,c,h});
                }
                if(input == 0) {
                    unripe++;
                }
            }
        }
    }

    if(unripe == 0) {
        cout << 0;
        return 0;
    }

    bfs();

    for(int h=0; h<H; h++) {
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(maps[r][c][h] == 0) {
                    cout << -1;
                    return 0;
                }

                ans = max(ans, maps[r][c][h]);
            }
        }
    }

    cout << ans-1;
    
    
    return 0;
}