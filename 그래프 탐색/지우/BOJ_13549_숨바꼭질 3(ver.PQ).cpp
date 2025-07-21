#include <iostream>
#include <queue>
#include <set>

using namespace std;

int N, K;

int main() {
    cin >> N >> K;
    
    priority_queue< pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>> > pq;
    // priority_queue<pair<int, int>> pq;  --  큰 수부터 출력됨
    
    set<int> viss;
    pq.push({0, N});

    while(!pq.empty()) {
        pair<int,int> curr = pq.top(); pq.pop();
        int t = curr.first;
        int x = curr.second;

        if(x==K) {
            cout << t;
            return 0;
        }

        if(2*x <= 100000 && !viss.count(2*x)) {
            viss.insert(2*x);
            pq.push({t, 2*x});
        }
        if(x-1>=0 && !viss.count(x-1)) {
            viss.insert(x-1);
            pq.push({t+1, x-1});
        }
        if(x+1 <= 100000 && !viss.count(x+1)) {
            viss.insert(x+1);
            pq.push({t+1, x+1});
        }
        
    }
     
    return 0;
}