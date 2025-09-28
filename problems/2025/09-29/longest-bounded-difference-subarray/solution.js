class Solution {
  longestSubarray(arr, x) {
    const n = arr.length;
    const maxDQ = []; // indices, decreasing by value
    const minDQ = []; // indices, increasing by value
    let bestLen = 0, bestL = 0;
    let l = 0;
    for (let r = 0; r < n; r++) {
      while (maxDQ.length && arr[maxDQ[maxDQ.length - 1]] < arr[r]) maxDQ.pop();
      maxDQ.push(r);
      while (minDQ.length && arr[minDQ[minDQ.length - 1]] > arr[r]) minDQ.pop();
      minDQ.push(r);
      while (maxDQ.length && minDQ.length && arr[maxDQ[0]] - arr[minDQ[0]] > x) {
        if (maxDQ[0] === l) maxDQ.shift();
        if (minDQ[0] === l) minDQ.shift();
        l++;
      }
      const curLen = r - l + 1;
      if (curLen > bestLen) { bestLen = curLen; bestL = l; }
    }
    return arr.slice(bestL, bestL + bestLen);
  }
}

console.log(new Solution().longestSubarray([8,4,5,6,7], 3)); // [4,5,6,7]
console.log(new Solution().longestSubarray([1,10,12,13,14], 2)); // [12,13,14]
