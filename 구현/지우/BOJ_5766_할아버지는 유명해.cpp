#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    while(1) {
        int N; int M;
        cin >> N >> M;

        if(N == 0 && M == 0) break;
    
        vector<int> v(10002, 0);

        // 이긴 횟수 저장 
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                int player;
                cin >> player;
    
                v[player]++;
            }
        }
    
        vector<int> scores = v;
        sort(scores.begin(), scores.end());
        int second = scores[scores.size()-2];

        vector<int> answers;
        for(int i=0; i<v.size(); i++) {
            if(v[i] == second) {
                answers.push_back(i);
            }
        }

        for(int i=0; i<answers.size(); i++) {
            cout << answers[i] << " ";
        }

        cout << "\n";
        
    }
    
    return 0;
}