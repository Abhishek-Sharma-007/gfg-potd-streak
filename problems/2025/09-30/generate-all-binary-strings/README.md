# Generate all binary strings

Given `n`, generate all binary strings of length `n` in ascending lexicographic order.

## Approach (backtracking)
Build strings left-to-right; at each position choose '0' then '1'. This naturally yields ascending order.

Time: O(n * 2^n), Space: O(n) recursion (+ output).
