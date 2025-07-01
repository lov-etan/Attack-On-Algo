#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; long K;
    cin >> N >> K;

    vector<int> v(N+1, 0);

    for(int i=1; i<=N; i++) {
        cin >> v[i];
    }

    int idx = 1;
    bool isReturn = false;
    while(1) {

        long left = K - v[idx];
        // cout << idx << "에서" << left << "\n";

        if(left < 0) {
            cout << idx;
            break;
        }

        if(!isReturn) {
            idx++;
            if(idx > N) {
                isReturn = true;
                idx--;
            }
        } else {
            idx--;
        }

        K = left;

        
    }
    
    return 0;
}