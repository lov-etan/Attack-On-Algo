#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

using namespace std;

int N; int currNum;
vector<vector<int>> maps; vector<int> counts;
queue<pair<int,int>> q;

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<N;
}

void bfs(int r, int c) {
    maps[r][c] = currNum; 
    int cnt = 0;
    
    q.push({r,c});
    while(!q.empty()) {
        pair curr = q.front(); q.pop();
        cnt++;

        for(int d=0; d<4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];

            if(inRange(nr, nc) && maps[nr][nc] == 1) {
                maps[nr][nc] = currNum;
                q.push({nr, nc});
            }
        }
    }

    counts.push_back(cnt);
}

int main() {
    
    cin >> N;
    currNum = 2;
    maps.resize(N, vector<int>(N, 0));
    counts.resize(0);

    for(int r=0; r<N; r++) {
        string s; cin >> s;
        for(int c=0; c<N; c++) {
            int input; input = s[c] - '0';
            maps[r][c] = input;
        }
    }

    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            if(maps[r][c] == 1) {
                bfs(r, c);
                currNum++;
            }
        }
    }

    sort(counts.begin(), counts.end());

    cout << counts.size() << "\n";
    for(int i=0; i<counts.size(); i++) {
        cout << counts[i] << "\n";
    } 
    return 0;
}