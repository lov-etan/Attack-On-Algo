#include <iostream>
#include <set>

using namespace std;

int main() {
    set<int> s;
    
    for(int i=0; i<28; i++) {
        int st_num;
        cin >> st_num;

        s.insert(st_num);
    }

    for(int i=1; i<=30; i++) {
        if(!s.count(i)) {
            cout << i << "\n";
        }
    }

    return 0;
    
}