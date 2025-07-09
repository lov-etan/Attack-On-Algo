#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int N; cin >> N;
    vector<vector<int>> adj(N+1,vector<int>(0,0));

    for(int i=0; i<N-1; i++) {
        int a; int b;
        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    vector<int> p(N+1, 0);
    p[1] = 1;

    queue<int> q;
    q.push(1);
    while(!q.empty()) {
        int par = q.front(); q.pop();

        for(auto child : adj[par]) {
            if(p[child] == 0) {
                p[child] = par;
                q.push(child);
            }
        }
    }

    for(int i=2; i<=N; i++) {
        cout << p[i] << "\n";
    }

    
    return 0;
}