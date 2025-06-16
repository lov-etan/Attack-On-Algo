#include <iostream>
#include <vector>
#include <set>

using namespace std;
                //우하 좌하
vector<int> dr = {1, 1};
vector<int> dc = {1, -1};

int main() {
    vector<vector<int>> bingo(5, vector<int>(5,0));
    vector<vector<bool>> visited(5, vector<bool>(5, false));
    set<pair<int, int>> set; // {r,c} <- 빙고 시작점 저장
    
    for(int r=0; r<5; r++) {
        for(int c=0; c<5; c++) {
            cin >> bingo[r][c];
        }
    }

    for(int i=1; i<=25; i++) { // 사회자가 몇 번째 수를 불렀는지
        int mc;
        cin >> mc;

        int r = 0; int c = 0;

        //해당하는 값의 r, c를 찾는다. 
        for(int rr=0; rr<5; rr++) {
            for(int cc=0; cc<5; cc++) {
                if(bingo[rr][cc] == mc) {
                    r = rr; // ㅋㅋ 여기서 int r = rr; 이거 때문에 초기화가 안됨
                    c = cc;
                }
            }
        }

        visited[r][c] = true;
        
        // 가로? 해당 r부터 본다. - 우 ㄱㄱ
        if(!set.count({r,0})) { // 가로줄의 시작점 이미 방문한 적이 있나? 
            int isBingo = false;
            for(int nc=0; nc<5; nc++) {
                if(!visited[r][nc]) {
                    isBingo = false;
                    break;
                }
                isBingo = true;
            }

            if(isBingo) {
                set.insert({r,0});
            }
        }

        // 세로? 해당 c부터 본다. 
        if(!set.count({0,c})) { // 가로줄의 시작점 이미 방문한 적이 있나? 
            int isBingo = false;
            for(int nr=0; nr<5; nr++) {
                if(!visited[nr][c]) {
                    isBingo = false;
                    break;
                }
                isBingo = true;
            }

            if(isBingo) {
                set.insert({0,c});
            }
        }

        // 대각선? 왼쪽끝[0,0]
        if(!set.count({0,0})) {
            int isBingo = false;
            for(int n=0; n<5; n++) {
                if(!visited[0+dr[0]*n][0+dc[0]*n]) {
                    isBingo = false;
                    break;
                }
                isBingo = true;
            }

            if(isBingo) {
                set.insert({0,0});
            }
        }


        // 대각선? 오른쪽끝 [0,4]
        if(!set.count({0,4})) {
            int isBingo = false;
            for(int n=0; n<5; n++) {
                if(!visited[0+dr[1]*n][4+dc[1]*n]) {
                    isBingo = false;
                    break;
                }
                isBingo = true;
            }

            if(isBingo) {
                set.insert({0,4});
            }
        }

        if(set.size() >= 3) {
            cout << i;
            break;
        }
            
    }
    
    return 0;
}