#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

int N; int M;
vector<vector<int>> adj;
vector<int> ans;

int bfs(int n) {
    queue<int> q;
    vector<bool> vis(N+1, false);
    int answer = 1;

    q.push(n);
    vis[n] = true;

    while(!q.empty()) {
        int curr = q.front(); q.pop();
        answer++;

        for(auto nxt : adj[curr]) {
            if(!vis[nxt]) {
                vis[nxt] = true;
                q.push(nxt);
            }
        }
    }

    return answer;
}


int main() {
    cin >> N >> M;
    adj.resize(N+1, vector<int>(0,0));
    ans.resize(N+1);

    for(int i=0; i<M; i++) {
        int A; int B;
        cin >> A >> B;

        adj[B].push_back(A);
    }
    
    int maxHackNum = -1;
    for(int i=1; i<=N; i++) {
        ans[i] = bfs(i);
        maxHackNum = max(ans[i], maxHackNum);
    }

    for(int i=1; i<=N; i++) {
        if(maxHackNum == ans[i]) {
            cout << i << " ";
        }
    }

    return 0;
}