function nextGreater(arr) {
  const n = arr.length;
  const ans = Array(n).fill(-1);
  const st = []; // stack of indices
  for (let i = 2 * n - 1; i >= 0; i--) {
    const j = i % n;
    while (st.length && arr[st[st.length - 1]] <= arr[j]) st.pop();
    if (i < n && st.length) ans[j] = arr[st[st.length - 1]];
    st.push(j);
  }
  return ans;
}

console.log(nextGreater([1,3,2,4]));      // [3,4,4,-1]
console.log(nextGreater([0,2,3,1,1]));    // [2,3,-1,2,2]

