#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> v(N+1);

    for(int i=1; i<=N; i++) {
        cin >> v[i]; 
    }

    int M; // 학생 수
    cin >> M;

    for(int i=0; i<M; i++) {
        int gender;
        cin >> gender;
        int num;
        cin >> num;

        if(gender == 1) {
            int cnt = N / num; 
            for(int j=1; j<=cnt; j++) {
               v[num*j] = v[num*j] == 0 ? 1 : 0;
            }
        }
        else if(gender == 2) {
            
            int pointer = 1;
            while(num-pointer>=1 && num+pointer<=N && v[num-pointer] == v[num+pointer]) {
                pointer++;
            }

            for(int j=num-pointer+1; j<num+pointer; j++) {
                v[j] = v[j] == 0 ? 1 : 0;
            }
        }
    }

    for(int k=1; k<=N; k++) {
        cout << v[k] << " ";
        if(k%20 == 0) {
            cout << "\n";
        }
    }
    
    return 0;
}