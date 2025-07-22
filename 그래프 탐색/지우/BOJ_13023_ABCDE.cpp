#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<vector<int>> adj;
vector<bool> vis;

bool dfs(int node, int cnt) {

    if(cnt == 5) return true;

    for(auto nxt : adj[node]) {
        if(!vis[nxt]) {
            vis[nxt] = true;
            if(dfs(nxt, cnt+1)) return true;
            vis[nxt] = false;
        }
    }

    return false;
}

int main() {
    cin >> N >> M;
    adj.resize(N, vector<int>(0));

    for(int i=0; i<M; i++) {
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for(int i=0; i<N; i++) {
        vis.assign(N, false);
        vis[i] = true;
        if(dfs(i,1)) {
            cout << 1;
            return 0;
        }
    }

    cout << 0;
    return 0;
}