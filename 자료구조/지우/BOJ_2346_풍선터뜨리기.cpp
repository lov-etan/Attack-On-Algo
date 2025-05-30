#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N;
    cin >> N; 

    vector<int> v(N+1, 0);
    deque<int> q;

    for(int i=1; i<=N; i++) {
        cin >> v[i]; // 3 2 1 -3 -1
        q.push_back(i);   // 1 2 3 4 5 
    }

    while(!q.empty()) {
        int curr = q.front(); // 4
        q.pop_front(); // 4 빼  - 5 2 3
        cout << curr << " "; // 출력! 

        int move = v[curr]; // -3

        if(move > 0) {
            for(int i=0; i<move-1; i++) { // 0 1 
                q.push_back(q.front()); 
                q.pop_front(); // 4 5 2 3
            }
        } else {
            for(int i=0; i<abs(move); i++) { // 0 1 2 
                q.push_front(q.back());
                q.pop_back();
                
            }
        }
    }
}