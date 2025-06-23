// 25분 헤헷 
#include <iostream>
#include <queue>

using namespace std;

int main() {
    int N; int M;
    cin >> N >> M;

    vector<vector<int>> adj(N+1);
    bool visited[N+1] = {false}; //초기화 안해줘서 틀림.. 실화..?

    for(int i=0; i<M; i++) {
        int a; int b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int cnt = 0;
    queue<int> q;
    visited[1] = true;
    q.push(1);

    while(!q.empty()) {
        int curr = q.front(); q.pop();

        for(auto i : adj[curr]) {
            if(!visited[i]) {
                visited[i] = true;
                cnt++;
                q.push(i);
            }
        }

    }

    cout << cnt;
    
    return 0;
}