#include <iostream>
#include <vector>

using namespace std;

vector<int> dr = {0, 0, -1, 1, -1, 1, -1, 1};
vector<int> dc = {-1, 1, 0, 0, -1, -1, 1, 1};

int main() {
    int n;
    cin >> n;

    vector<vector<char>> map(n, vector<char>(n,0));
    vector<vector<int>> result(n, vector<int>(n,0));
    vector<pair<int, int>> bombs;
    bool isPop = false; // 이거 초기화 안했더니..... 틀림.. 
    
    for(int r=0; r<n; r++) {
        for(int c=0; c<n; c++) {
            cin >> map[r][c];

            if(map[r][c] == '*') {
                bombs.push_back({r, c});
            }
        }
    }

    for(int r=0; r<n; r++) {
        for(int c=0; c<n; c++) {
            result[r][c] = 9; // . 넣기 싫어서 9로 초기화 함
        }
    }

    for(int r=0; r<n; r++) {
        for(int c=0; c<n; c++) {
            char input;
            cin >> input;
            if(input == 'x') {

                // 지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸은 별표로 표시되어야 한다. <- '지뢰가 있는 모든 칸!!!!'
                if(!isPop && map[r][c] == '*') {
                    for( auto bomb : bombs) {
                        result[bomb.first][bomb.second] = 10;
                    }
                    isPop = true;
                    continue;
                }

                else if(result[r][c] != 10) {
                    int bombCnt = 0;
                    for(int d=0; d<8; d++) {
                        int nxtR = r + dr[d];
                        int nxtC = c + dc[d];

                        if(nxtR >= 0 && nxtR < n && nxtC >= 0 && nxtC < n && map[nxtR][nxtC] == '*') {
                            bombCnt++;
                        }
                    }

                    result[r][c] = bombCnt;
                }
                
            }
        }
    }

    for(int r=0; r<n; r++) {
        for(int c=0; c<n; c++) {
            if(result[r][c] == 9) {
                cout << ".";
            } 
            else if(result[r][c] == 10) {
                cout << "*";
            }
            else {
                cout << result[r][c];
            }
        }
        cout << "\n";
    }
    
    return 0;
}