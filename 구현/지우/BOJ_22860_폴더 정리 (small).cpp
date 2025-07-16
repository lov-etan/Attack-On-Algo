#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

int N; int M;
int 종류cnt; int 개수cnt;
map<string, vector<pair<int, string>>> maps;
map<string, bool> vis;


void bfs(string s) {
    queue<string> q;

    q.push(s);
    while(!q.empty()) {
        string par = q.front(); q.pop();
        
        for(auto child : maps[par]) {
            if(child.first == 0) {
                if(!vis[child.second]) {
                    vis[child.second] = true;
                    종류cnt++;
                }
                개수cnt++;
            } 
            else {
                q.push(child.second);
            }
        }
    }
}

string parsing(string s) {
    string result = "";
    int idx = 0;
    while(idx < s.length()) {
        if(s[idx] == '/') {
            result = "";
            idx++;
            continue;
        }
        result += s[idx++];
    }
    return result;
}

int main() {

    cin >> N >> M;

    for(int i=0; i<N+M; i++) {
        string a; string b; int isFolder;
        cin >> a >> b >> isFolder;
        maps[a].push_back({isFolder, b});
    }

    int C; cin >> C;
    for(int i=0; i<C; i++) {
        string query; cin >> query;
        
        종류cnt = 0; 개수cnt = 0;
        vis.clear();
        
        bfs(parsing(query));

        cout << 종류cnt << " " << 개수cnt << "\n";      
    }
    
    
    return 0;
}