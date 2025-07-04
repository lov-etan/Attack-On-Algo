#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int dr[] = {1,0,-1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<101 && c>=0 && c<101;
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    vector<vector<int>> maps(101,vector<int>(101,0));
    
    for(int i=0; i<rectangle.size(); i++) {
        int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2; 
        int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
        
        for(int r=sr; r<=er; r++) {
            for(int c=sc; c<=ec; c++) {
                maps[r][c] = 1;
            }
        }
    }
    
    for(int i=0; i<rectangle.size(); i++) {
        int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2; 
        int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
        
        for(int r=sr+1; r<er; r++) {
            for(int c=sc+1; c<ec; c++) {
                maps[r][c] = 0; // 안에 비우기 
            }
        }
    }
    
    queue<pair<int,int>> q;
    vector<vector<int>> dist(101,vector<int>(101,0));
    q.push({characterX*2,characterY*2});
    dist[characterX*2][characterY*2] = 1;
    
    while(!q.empty()) {
        pair<int,int> pos = q.front(); q.pop();
        int r = pos.first;
        int c = pos.second;
        
        if(r == itemX*2 && c == itemY*2) break;
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            
            if(inRange(nr, nc) && dist[nr][nc] == 0 && maps[nr][nc] == 1) {
                dist[nr][nc] = dist[r][c]+1;
                q.push({nr,nc});
            }
        }
    }
    
     return dist[itemX*2][itemY*2]/2; //좌표 2배 확장했기에 줄이기
}