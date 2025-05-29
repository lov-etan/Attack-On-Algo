// 메모리: 2020 KB 시간: 0 ms

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; int k;
    cin >> N;// 7
    cin >> k;// 3

    vector<int> v(N,0);

    for(int i=0; i<N; i++) {
        v[i] = i+1;
    }

    cout << "<";
    
    int curr = k-1; //2
    while(!v.empty()) {
        curr = (curr) % v.size(); // 현재 인덱스 (+보정)
        cout << v[curr]; // 1 2 4 5 6 7 
        v.erase(v.begin() + curr); // 1 2 4 5 7

        if(!v.empty()) {
            cout << ", ";
        }
        
        curr = (curr+k-1); // 2 + 3 - 1 = 4 
    }
    cout << ">";
}