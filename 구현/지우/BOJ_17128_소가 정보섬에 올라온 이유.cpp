#include <iostream>
#include <vector>

using namespace std;

vector<int> cows;
vector<int> scopes; // 범위별(시작점 기준) - 곱한 값
vector<vector<int>> whatScopes; // 번호별 - 각 어떤 범위에 있는지 
int N; int Q;

void mulnSum() {

    for(int i=1; i<=N; i++) {
        int idx = i; int scopeScore = 1; int cnt = 0;
        while(cnt < 4) {
            scopeScore *= cows[idx];
            whatScopes[idx].push_back(i);
            idx = (idx+1)%(N+1);
            if(idx == 0) idx = 1;
            
            cnt++;
        }
        scopes[i] = scopeScore;
    }

    return;
}

int sumAll() {
    int ans = 0;
    for(int i=1; i<=N; i++) {
        ans += scopes[i];
    }
    return ans;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    cin >> N >> Q;
    cows.resize(N+1, 0); scopes.resize(N+1, 0); 
    whatScopes.resize(N+1, vector<int>(0,0));
    for(int i=1; i<=N; i++){
        cin >> cows[i];
    }

    mulnSum();
    int total = sumAll();

    for(int i=0; i<Q; i++) {
        int q; cin >> q;
        for(auto change : whatScopes[q]) {
            total -= scopes[change];
            scopes[change] = -1 * scopes[change];
            total += scopes[change];
        }
        
        cout << total << "\n";
    }

    
    return 0;
}