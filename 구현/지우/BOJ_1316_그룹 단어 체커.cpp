#include <iostream>
#include <set>

using namespace std;

int cnt;

void isGroup(string input) {

    set<char> s;

    s.insert(input[0]);
    
    for(int i=1; i<input.length(); i++) {
        // 
        if(input[i-1] != input[i]) {
            if(s.count(input[i])) {
                // cout << "그룹 아님" << input[i-1] << " 현재 " << input[i] << "\n";
                return;
            }
            s.insert(input[i]);
        } else {
            s.insert(input[i]); 
        }
    }
    cnt ++;
    return;
}



int main() {

    int N; cin >> N;
    cnt = 0;
    for(int i=0; i<N; i++) {
        string input; 
        cin >> input;
        isGroup(input);
    }

    cout << cnt;
    return 0;
}