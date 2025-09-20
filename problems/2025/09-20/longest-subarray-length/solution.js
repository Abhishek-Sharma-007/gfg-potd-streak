class Solution {
  longestSubarray(arr) {
    const n = arr.length;
    const left = Array(n).fill(-1);
    const right = Array(n).fill(n);
    const st = [];
    for (let i = 0; i < n; i++) {
      while (st.length && arr[st[st.length - 1]] <= arr[i]) st.pop();
      left[i] = st.length ? st[st.length - 1] : -1;
      st.push(i);
    }
    st.length = 0;
    for (let i = n - 1; i >= 0; i--) {
      while (st.length && arr[st[st.length - 1]] < arr[i]) st.pop();
      right[i] = st.length ? st[st.length - 1] : n;
      st.push(i);
    }
    let ans = 0;
    for (let i = 0; i < n; i++) {
      const span = right[i] - left[i] - 1;
      if (span >= arr[i]) ans = Math.max(ans, span);
    }
    return ans;
  }
}

const sol = new Solution();
console.log(sol.longestSubarray([1,2,3]));     // 3
console.log(sol.longestSubarray([6,4,2,5]));   // 0
