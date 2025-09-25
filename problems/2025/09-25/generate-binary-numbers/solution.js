class Solution {
  generateBinary(n) {
    const res = [];
    const q = ["1"];
    for (let i = 0; i < n; i++) {
      const s = q.shift();
      res.push(s);
      q.push(s + "0");
      q.push(s + "1");
    }
    return res;
  }
}

console.log(new Solution().generateBinary(4)); // ["1","10","11","100"]
