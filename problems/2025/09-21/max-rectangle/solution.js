class Solution {
  maxArea(mat) {
    if (!mat || !mat.length || !mat[0].length) return 0;
    const r = mat.length, c = mat[0].length;
    const heights = Array(c).fill(0);
    let ans = 0;
    for (let i = 0; i < r; i++) {
      for (let j = 0; j < c; j++) {
        heights[j] = mat[i][j] === 1 ? heights[j] + 1 : 0;
      }
      const st = [];
      for (let k = 0; k <= c; k++) {
        const h = k < c ? heights[k] : 0;
        while (st.length && heights[st[st.length - 1]] > h) {
          const ht = heights[st.pop()];
          const left = st.length ? st[st.length - 1] : -1;
          const width = k - left - 1;
          ans = Math.max(ans, ht * width);
        }
        st.push(k);
      }
    }
    return ans;
  }
}

const sol = new Solution();
console.log(sol.maxArea([[0,1,1,0],[1,1,1,1],[1,1,1,1],[1,1,0,0]])); // 8
console.log(sol.maxArea([[0,1,1],[1,1,1],[0,1,1]]));                 // 6
