#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

int N, K;
vector<int> springs;
set<int> vis; 
priority_queue<vector<long long>, vector<vector<long long>>, greater<vector<long long>>> pq;
long long ans; int homeCnt;

int pluses[] = {-1, 1};

void bfs() {
    while(!pq.empty() && homeCnt < K) {
        vector<long long> curr = pq.top(); pq.pop();
        
        long long distance = curr[0];
        int x = curr[1];
        int springPos = curr[2];
        
        homeCnt++;
        ans += distance;

        for(int i=0; i<2; i++) {
            int nx = x + pluses[i];
            if(!vis.count(nx)) {
                long long nxtDistance = abs((long long)springPos - nx);
                vis.insert(nx);
                pq.push({nxtDistance, nx, springPos});
            }
        }
    }
}

int main() {
    cin.tie(0); ios::sync_with_stdio(0);
    cin >> N >> K;
    
    for(int i=0; i<N; i++) {
        int spring; cin >> spring; homeCnt--;
        pq.push({0, spring, spring}); vis.insert(spring);
    }

    bfs();
    cout << ans;
    
    return 0;
}