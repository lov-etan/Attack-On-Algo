#include <iostream>
#include <vector>
#include <map>

using namespace std;

map<char, pair<int, int>> m;
vector<char> 자음 = {'q','w','e','r','t','a','s','d','f','g','z','x','c','v'};
vector<char> 모음 = {'y','u','i','o','p','h','j','k','l', 'b','n','m'};

pair<int, int> Pos(char alph) {
    return m.find(alph) -> second;
};

bool isIn자음(char alph) {
    for(auto 자: 자음) {
        if(자 == alph) {
            return true;
        }
    }
    return false;
}

bool isIn모음(char alph) {
    for(auto 모: 모음) {
        if(모 == alph) {
            return true;
        }
    }
    return false;
}

int main() {
    int idx = 0;
    for(int r=0; r<5; r++) {
        for(int c=0; c<5; c++) {
            if(r==2 && c==4) break;

            char alphabet = 자음[idx++];
            m.insert({alphabet, {r,c}});
        }
    }

    idx = 0;
    for(int r=0; r<5; r++) {
        for(int c=5; c<10; c++) {
            if(r==1 && c==9) continue;
            if(r==2 && c>=8) continue;

            char alphabet = 모음[idx++];
            if(r==2) {
                m.insert({alphabet, {r,c-1}});
            } else {
                m.insert({alphabet, {r,c}});
            }
        }
    }


    // 키보드 입력하기 
    char left;
    char right;
    cin >> left; cin >> right;
    pair<int, int> currLeft = Pos(left);
    pair<int, int> currRight = Pos(right);

    int answer = 0;
    string input;
    cin >> input;
    for(int i=0; i<input.length(); i++) {
        char alph = input[i]; //z
        pair<int, int> inputPos = Pos(input[i]);
        
        if(isIn자음(alph)) { // 자음
            // 현위치와 비교
            int 값 = abs(currLeft.first - inputPos.first) + abs(currLeft.second - inputPos.second);
            answer += 값;
            answer++;
            currLeft.first = inputPos.first;
            currLeft.second = inputPos.second;
        } else { // 모음
            // 현위치와 비교
            int 값 = abs(currRight.first - inputPos.first) + abs(currRight.second - inputPos.second);
            answer += 값;
            answer++;
            currRight.first = inputPos.first;
            currRight.second = inputPos.second;
        }
    }

    cout << answer;

        
    return 0;
}