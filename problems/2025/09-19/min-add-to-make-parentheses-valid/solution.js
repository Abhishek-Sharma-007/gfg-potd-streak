class Solution {
  minParentheses(s) {
    let openNeeded = 0;
    let insertions = 0;
    for (const ch of s) {
      if (ch === '(') {
        openNeeded++;
      } else {
        if (openNeeded > 0) openNeeded--;
        else insertions++;
      }
    }
    return insertions + openNeeded;
  }
}

const sol = new Solution();
console.log(sol.minParentheses("(()("));  // 2
console.log(sol.minParentheses(")))"));   // 3
console.log(sol.minParentheses(")()()")); // 1
