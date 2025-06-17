#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<char>> map;

void drawStar(int n, int x, int y) {
    if(n == 1) {
        map[x][y] = '*';
        return;
    }

    // 가로
    for(int c=y; c < 4*(n-1)+1+y; c++) { // 2
        map[x][c] = '*';
        map[4*(n-1)+x][c] = '*';
    }

    // 세로
    for(int r=x; r < 4*(n-1)+1+x; r++) {
        map[r][y] = '*';
        map[r][4*(n-1)+y] = '*';
    }

    drawStar(n-1, x+2, y+2); // 2 2 2 
}

int main() {
    cin >> N;
    map = vector<vector<char>>(4*(N-1)+1, vector<char>(4*(N-1)+1,' ')); // '' <- 이거 안됨
    
    drawStar(N, 0, 0);

    for(int r=0; r< 4*(N-1)+1; r++) {
        for(int c=0; c< 4*(N-1)+1; c++) {
            cout << map[r][c];
        }
        cout << "\n";
    }
    
    return 0;
}