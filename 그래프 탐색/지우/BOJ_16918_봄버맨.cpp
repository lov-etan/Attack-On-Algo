#include <iostream>
#include <vector>

using namespace std;
int R; int C; int N;
vector<vector<char>> allBomb;
vector<vector<char>> someBomb;
vector<vector<char>> tmpBomb;
vector<vector<bool>> vis;

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<R && c>=0 && c<C;
}

void letsbomb() {
    vis.assign(R, vector<bool>(C,false));
    tmpBomb = someBomb;
    
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            if(someBomb[r][c] == '.' && !vis[r][c]) {
                someBomb[r][c] = 'O';
            }
            else if(someBomb[r][c] == 'O' && !vis[r][c]) {
                someBomb[r][c] = '.';
                vis[r][c] = true;
                for(int d=0; d<4; d++) {
                    int nr = r + dr[d]; int nc = c + dc[d];
                    if(inRange(nr, nc) && tmpBomb[nr][nc] != 'O') {
                        vis[nr][nc] = true;
                        someBomb[nr][nc] = '.';
                    }
                }
            }
        }
    }
}

void printMap(bool i);

int main() {
    cin >> R >> C >> N;
    allBomb.resize(R, vector<char>(C,'O'));
    someBomb.resize(R, vector<char>(C,'\0'));

    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            char input; cin >> input;
            someBomb[r][c] = input;
        }
    }

    for(int i=0; i<=N; i++) { // 틱 톡 틱 톡
        if(i != 1 && (i%2)!=0) { // 홀
            letsbomb();
        }

        if(i==N) {
            if(i==0 || (i%2)!=0) { // 홀수
                printMap(0); // 부분
            } else {
                printMap(1); // 전체 
            }
        }
    }
    return 0;
}

void printMap(bool isAll) {
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            if(isAll) {
                cout << allBomb[r][c];
            } else {
                cout << someBomb[r][c];
            }
        }
        cout << "\n";
    }
}