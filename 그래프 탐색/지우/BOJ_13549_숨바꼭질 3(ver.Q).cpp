#include <iostream>
#include <queue>
#include <set>

using namespace std;

int N, K;

int main() {
    cin >> N >> K;
    queue<pair<int,int>> q;
    set<int> viss;
    q.push({N, 0});

    while(!q.empty()) {
        pair<int,int> curr = q.front(); q.pop();
        int x = curr.first;
        int t = curr.second;

        if(x==K) {
            cout << t;
            return 0;
        }
        
        if(2*x <= 100000 && !viss.count(2*x)) {
            viss.insert(2*x);
            q.push({2*x, t});
        }
        if(x-1>=0 && !viss.count(x-1)) {
            viss.insert(x-1);
            q.push({x-1, t+1});
        }
        if(x+1 <= 100000 && !viss.count(x+1)) {
            viss.insert(x+1);
            q.push({x+1, t+1});
        }
        
    }
     
    return 0;
}