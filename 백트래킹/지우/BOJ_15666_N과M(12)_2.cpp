#include <iostream>
#include <algorithm>
#include <vector> 
#include <set>

using namespace std;

int N;
int M;
vector<int> nums;
set<vector<int>> s;

void mn(int Pidx, int idx, vector<int> P) {
    if(Pidx == M) {
        if(s.insert(P).second == true) { // set.insert(값) = pair<iterator, bool(true:새로 삽입/ false: 이미 존재)>
            //삽입 가능(새로 들어갔음 -> 중복 아님)
            for(int i=0; i<M; i++) {
                cout << P[i] << " ";
            }
            cout << "\n";
            s.insert(P);
            return;
        } else { // 삽입 불가능(이미 있었음 => 중복)
            return;
        }
    }

    for(int i=idx; i<N; i++) {
        P[Pidx] = nums[i];
        mn(Pidx+1, i, P);
    }
}

int main() {
    cin.tie(NULL);
    
    cin >> N;
    cin >> M;
    nums.assign(N,0);
    for(int i=0; i<N; i++) {
        cin >> nums[i];
    }
    sort(nums.begin(), nums.end()); //1 7 9 9

    vector<int> P(M, 0);
    mn(0, 0, P);
    
}