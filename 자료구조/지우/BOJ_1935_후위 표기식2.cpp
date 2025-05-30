// 2024 KB	0 ms

#include <iostream>
#include <stack>
#include <vector>
#include <iomanip>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N;
    cin >> N;

    string s;
    cin >> s;

    vector<int> v(26);
    for(int i=0; i<N; i++) {
        int num;
        cin >> num;
        v[i] = num;      //v[A] = 1, v[B] = 2, ,,,,,
    }

    stack<double> stack;
    for(int i=0; i<s.length(); i++) {  // ABC*+DE/-
        if(s[i] >= 'A' && s[i] <='Z') {
            stack.push(v[s[i]-'A']);
            
        } else if(s[i] == '+') {
            double b = stack.top(); stack.pop();
            double a = stack.top(); stack.pop();
            double result = a + b;
            stack.push(result);
        } else if(s[i] == '-') {
            double b = stack.top(); stack.pop();
            double a = stack.top(); stack.pop();
            double result = a - b;
            stack.push(result);
        } else if(s[i] == '*') {
            double b = stack.top(); stack.pop();
            double a = stack.top(); stack.pop();
            double result = (double) a * b;
            stack.push(result);
        } else if(s[i] == '/') {
            double b = stack.top(); stack.pop();
            double a = stack.top(); stack.pop();
            double result = (double) a / b;
            stack.push(result);
        }
    }

    cout << fixed << setprecision(2) << stack.top();
}