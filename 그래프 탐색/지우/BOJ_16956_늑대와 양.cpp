#include <iostream>
#include <vector>

using namespace std;
int R; int C;
int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<R && c>=0 && c<C;
}

int main() {
    cin >> R >> C;

    vector<vector<char>> maps(R, vector<char>(C));

    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            char input; cin >> input;

            if(input == '.') {
                maps[r][c] = 'D';
            } else {
                maps[r][c] = input;
            }
        }
    }

    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            if(maps[r][c] == 'W') {
                for(int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(inRange(nr, nc) && maps[nr][nc] == 'S') {
                        cout << 0;
                        return 0;
                    }
                }
            }
        }
    }

    cout << 1 << "\n";
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            cout << maps[r][c];
        }
        cout << "\n";
    }  
    
    return 0;
}