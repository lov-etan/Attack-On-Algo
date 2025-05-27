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
        for(int i=0; i<M; i++) {
            cout << P[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=idx; i<N; i++) {
        if(i>idx && nums[i] == nums[i-1]) continue; //최적화 적용
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