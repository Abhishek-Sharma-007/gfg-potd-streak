class Solution {
  reverseQueue(q) {
    const st = [];
    while (q.length) st.push(q.shift());
    while (st.length) q.push(st.pop());
  }
}

const sol = new Solution();
const q = [5,10,15,20,25];
sol.reverseQueue(q);
console.log(q); // [25,20,15,10,5]
