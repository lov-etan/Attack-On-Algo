#include <iostream>

using namespace std;

int main() {
    int N; int K;
    cin >> N >> K;

    int S[N+1];
    for(int i=1; i<=N; i++) {
        cin >> S[i];
    }

    int D[N+1];
    for(int i=1; i<=N; i++) {
        cin >> D[i];
    }

    int P[N+1];
    for(int k=0; k<K; k++) {
        for(int i=1; i<=N; i++) {
            int move = S[i];
            int idx = D[i];
            P[idx] = move;
        }

        // 배열 복사
        for(int i=1; i<=N; i++) {
            S[i] = P[i];
        }
    }

    for(int i=1; i<=N; i++) {
        cout << P[i] << " ";
    }
    
    return 0;
}