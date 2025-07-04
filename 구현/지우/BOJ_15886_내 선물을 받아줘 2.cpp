#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N; cin >> N;
    string s; cin>> s;

    int maxP = 0;
    vector<int> p(N,0);

    //시작점 ㄱ
    for(int i=0; i<N; i++) {
        
        vector<bool> visited(N,false);
        visited[i] = true;
        int idx = i; int tmpP = 0;
        while(idx>=0 && idx<N) {
            if(s[idx] == 'E') {
                idx++;
            } else if(s[idx] == 'W') {
                idx--;
            }

            if(visited[idx]) {
                break;
            } else {
                visited[idx] = true;
                tmpP = max(tmpP, p[idx]);
            }
        }

        if(tmpP == 0) {
            maxP++;
        }

        for(int j=0; j<N; j++) {
            if(visited[j]) {
                p[j] = maxP;
            }
        }
    }

    cout << maxP;
    
    return 0;
}