#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int T;
    cin >> T;

    for(int tc=1; tc<=T; tc++) {
        int N; cin >> N;
        int mn = 1000001; int mx = -1000001;

        for(int i=0; i<N; i++) {
            int num; cin >> num;
            mn = min(mn, num);
            mx = max(mx, num);
        }

        cout << mn << " " << mx << "\n";
    }
    
    return 0;
}