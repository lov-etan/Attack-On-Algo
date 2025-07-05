#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int N; int M;
vector<vector<int> > arr;
vector<vector<int>> dist;

int dr[] = {1,0,-1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}
 
int bfs() {
    queue<pair<int,int>> q;
    pair<int, int> start = {0,0};
    q.push(start);
    dist[0][0] = 1;
    
    
    while(!q.empty()) {
        pair<int, int> pos = q.front(); q.pop();
        
        int r = pos.first;
        int c = pos.second;
        
        // cout << r << " " << c << "\n";

        if(r == N-1 && c == M-1) {
            return dist[r][c];
        }

        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(inRange(nr,nc) && dist[nr][nc] == 0 && arr[nr][nc] == 1) {
                dist[nr][nc] = dist[r][c]+1;
                
                pair<int, int> nxtPos = {nr, nc};
                q.push(nxtPos);
            }
        }
    }
    
    return -1;
    
    
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    arr = maps; N = maps.size(); M = maps[0].size();
    dist.resize(N, vector<int>(M,0));
    
    answer = bfs();
    return answer;
}