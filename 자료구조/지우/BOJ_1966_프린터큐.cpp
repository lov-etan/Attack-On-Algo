#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int T;
    cin >> T;

    for(int tc=1; tc<=T; tc++) {
        int N; int M;
        cin >> N >> M;

        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for(int i=0; i<N; i++) {
            int w; cin >> w;
            q.push({w, i}); // <중요도, 인덱스> 
            pq.push(w);
        }

        int cnt = 0; //초기화!!
        
        while(!q.empty()) {
            int max = pq.top();
            pair<int, int> curr = q.front();
            
            if(curr.first <max) { // 중요도 미달
                q.push(q.front());
                q.pop();
            } else { //중요도 제일 높은 친구
                cnt++;

                if(curr.second == M) {
                    cout << cnt << "\n";
                    break;
                }
                
                q.pop();
                pq.pop();
            }
        }
    }
    
}