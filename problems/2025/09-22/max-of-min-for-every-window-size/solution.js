class Solution {
  maxOfMins(arr) {
    const n = arr.length;
    const prev = Array(n).fill(-1);
    const next = Array(n).fill(n);
    const st = [];
    // previous smaller (strict)
    for (let i = 0; i < n; i++) {
      while (st.length && arr[st[st.length - 1]] >= arr[i]) st.pop();
      prev[i] = st.length ? st[st.length - 1] : -1;
      st.push(i);
    }
    st.length = 0;
    // next smaller (strict)
    for (let i = n - 1; i >= 0; i--) {
      while (st.length && arr[st[st.length - 1]] > arr[i]) st.pop();
      next[i] = st.length ? st[st.length - 1] : n;
      st.push(i);
    }
    const res = Array(n).fill(0);
    for (let i = 0; i < n; i++) {
      const length = next[i] - prev[i] - 1;
      const idx = length - 1;
      res[idx] = Math.max(res[idx], arr[i]);
    }
    for (let i = n - 2; i >= 0; i--) res[i] = Math.max(res[i], res[i + 1]);
    return res;
  }
}

const sol = new Solution();
console.log(sol.maxOfMins([10,20,30,50,10,70,30])); // [70,30,20,10,10,10,10]
console.log(sol.maxOfMins([10,20,30]));             // [30,20,10]
