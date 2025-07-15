#include <iostream>
#include <deque>

using namespace std;

int main() {
    string input;
    getline(cin, input); // 한 줄 전부 다 받는 법

    deque<string> dq;

    int idx = 0;
    while(idx < input.length()) {

        string tmp = "";

        if(input[idx] != '<') {
            while(input[idx] != '<') {
                tmp += input[idx++];
            } 
        }
        else {
            while(input[idx] != '>') {
                tmp += input[idx++];
            }
            tmp += input[idx++];
        }
        dq.push_back(tmp);
    }

    while(!dq.empty()) {
        
        string s = dq.front();
        // cout << s << "\n";

        if(s[1] == '/') {
            dq.pop_front();
        }
        else if(s[1] == 'm') {
            dq.pop_front();
        }
        else if(s[1] == 'd') {
            int idx = 11;
            string tmp = "title : ";
            while(idx < s.length()) {
                if(s[idx] == '"') {
                    idx++;
                    while(s[idx] != '"') {
                        tmp += s[idx++];
                    }
                    break;
                }
                idx++;
            }
            cout << tmp << "\n";
            dq.pop_front();
        }
        else if(s[1] == 'p') {

            string tmp = "";
            dq.pop_front();
            while(dq.front() != "</p>") {
                string curr = dq.front();
                if(curr[0] != '<') { // 괄호 없는 썡글자일 경우
                    tmp += curr;
                }
                dq.pop_front();
            }

            // 공백이 2개 이상 연속 붙어있다면 하나의 공백으로 바꾼다.
            // 문장과 시작과 끝에 공백이 있다면 지운다.
            string result = "";
            for(int i=0; i<tmp.length(); i++) {
                if((i==0 || i==tmp.length()) && tmp[i] == ' ') {
                    continue;
                }
                else if(i!=0 && tmp[i-1] == ' ' && tmp[i] == ' ') {
                    continue;
                }

                result += tmp[i];
            }
            
            cout << result << "\n";
            dq.pop_front();
        }
    }
    
    return 0;
}