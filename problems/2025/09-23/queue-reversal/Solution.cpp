#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    void reverseQueue(queue<int> &q) {
        stack<int> st;
        while (!q.empty()) {
            st.push(q.front());
            q.pop();
        }
        while (!st.empty()) {
            q.push(st.top());
            st.pop();
        }
    }
};

int main() {
    queue<int> q;
    for (int x : {5,10,15,20,25}) q.push(x);
    Solution().reverseQueue(q);
    while (!q.empty()) { cout << q.front() << (q.size()>1?' ':'\n'); q.pop(); }
    return 0;
}
