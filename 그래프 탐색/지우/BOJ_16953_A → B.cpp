#include <iostream>
#include <vector>
#include <climits>

using namespace std;
int A;
int B;
int minCnt;

void dfs(long curr, int cnt) {
    if(curr == A) {
        minCnt =  min(minCnt, cnt);
        return;
    }

    if(curr < A) {
        return;
    }
    
    if(curr % 2 == 0) {
        int curr1 = curr / 2;
        // cout << "현재1 " << curr1 << endl;
        dfs(curr1, cnt+1);
    }

    if((curr-1) % 10 == 0) {
        int curr2 = (curr - 1)/10;
        // cout << "현재2 " << curr2 << endl;
        dfs(curr2, cnt+1);
    }

    
}

int main() {
    cin >> A >> B;
    // cout << A << " " << B << endl;

    minCnt = INT_MAX;
    dfs(B,0);

    if(minCnt == INT_MAX) {
        cout << -1 << endl;
    } else {
        cout << minCnt+1 << endl;
    }

}