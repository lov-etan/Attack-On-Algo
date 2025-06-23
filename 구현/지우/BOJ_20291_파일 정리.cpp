#include <iostream>
#include <map>

using namespace std;

int main() {
    int T;
    cin >> T;

    map<string, int> mp;

    for(int t=0; t<T; t++) {

        string s; cin >> s;
        bool check = false;
        string extension = "";
        
        for(int i=0; i<s.length(); i++) {
            if(!check && s[i] == '.') {
                check = true;
            }
            else if(check) {
                extension += s[i];
            }
        }

        if(mp.count(extension)) {
            // 있어
            mp[extension]++;
        } else {
            mp.insert({extension, 1});
        }
        
    }

    for(auto m:mp) {
        cout << m.first << " " << m.second << "\n";
    }
    
    return 0;
}