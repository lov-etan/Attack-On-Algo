#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N;
vector<vector<int>> adj;
vector<int> visDfs;
vector<int> visBfs;

string dfsAns;
string bfsAns;

void dfs(int v) {
    visDfs[v] = true;
    dfsAns += to_string(v) + " ";

    for(auto nxt : adj[v]) {
        if(!visDfs[nxt]) {
            dfs(nxt);
        }
    }
}

void bfs(int v) {
    queue<int> q;
    visBfs[v] = true;
    q.push(v);

    while(!q.empty()) {
        int curr = q.front(); q.pop();
        bfsAns += to_string(curr) + " ";

        for(auto nxt : adj[curr]) {
            if(!visBfs[nxt]) {
                visBfs[nxt] = true;
                q.push(nxt);
            }
        }
    }
    
}


int main() {
    int M; int V;
    cin >> N >> M >> V;
    adj.resize(N+1, vector<int>(0,0));
    visDfs.resize(N+1, false);
    visBfs.resize(N+1, false);

    for(int i=0; i<M; i++) {
        int a; int b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for(int i=1; i<=N; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    // dfs
    visDfs[V] = true;
    dfsAns = "";
    dfs(V);

    // bfs
    bfsAns = "";
    bfs(V);

    cout << dfsAns << "\n" << bfsAns;
    
    return 0;
}