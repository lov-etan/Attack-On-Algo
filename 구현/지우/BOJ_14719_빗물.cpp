#include <iostream>
#include <vector>

using namespace std;

int main() {
    int H; int W; 
    cin >> H >> W;

    int ans = 0;

    vector<int> v(W, 0);
    for(int i=0; i<W; i++) {
        cin >> v[i];
    }
    
    for(int h = H; h>=0; h--) {
        int cnt = 0; //벽 수 - 2개면 막힌 것
        int tmp = 0;
        
        for(int i=0; i<W; i++) {
            if(h <= v[i]) {
                cnt++;

                if(cnt ==2) {
                    cnt = 1;
                    ans += tmp;
                    tmp = 0;
                }
            } else if(cnt != 0) { //시작점이 없는 경우에 쌓으면 안된다!
                tmp++;
            }    
        }
    }

    cout << ans;
    
    return 0;
}