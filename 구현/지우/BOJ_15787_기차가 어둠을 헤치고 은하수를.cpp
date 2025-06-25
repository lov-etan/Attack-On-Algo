#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main() {
    int N; int M;
    cin >> N >> M;

    vector<vector<int>> v(N+1, vector<int>(21, 0));

    for(int m=0; m<M; m++) {
        int command;
        cin >> command;

        if(command ==  1){
            int i; int x;
            cin >> i >> x;

            v[i][x] = 1; 
        }
        else if (command == 2) {
            int i; int x;
            cin >> i >> x;
            
            v[i][x] = 0;
        }
        else if (command == 3) {
            int i; cin >> i;
            
            for(int k=20; k>1; k--) {
                    v[i][k] = v[i][k-1];
            }

            v[i][1] = 0;
            
        }
        else if(command == 4) {
            int i; cin >> i;
            
            //아얠안뺐어.. vector<vector<int>> tmp(N+1, vector<int>(21, 0));
            for(int k=1; k<20; k++) {
                    v[i][k] = v[i][k+1];
            }

            v[i][20] = 0;
        } 
    }

    set<vector<int>> s;
    for(int j=1; j<=N; j++) {
        s.insert(v[j]); // 어차피 set은 중복된거 제거해
    }

    cout << s.size();

    
    return 0;
}