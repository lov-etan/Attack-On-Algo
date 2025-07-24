#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N; int start;
vector<int> arr; vector<int> ans;
vector<bool> vis;

bool dfs(int curr) {
    int nxt = arr[curr];
    if(!vis[nxt]) {
        vis[nxt] = true;
        if(dfs(nxt)) return true;
    }
    else if(nxt == start) {
        ans.push_back(start);
        return true;
    }

    return false;
}

int main() {
    cin >> N;
    arr.resize(N+1,0);
    for(int i=1; i<=N; i++) {
        cin >> arr[i];
    }

    for(int s=1; s<=N; s++) {
        vis.assign(N+1, false); vis[s] = true;
        start = s;
        dfs(s);
    }

    sort(ans.begin(), ans.end());
    cout << ans.size() << "\n";
    for(auto node : ans) {
        cout << node << "\n";
    }
    return 0;
}