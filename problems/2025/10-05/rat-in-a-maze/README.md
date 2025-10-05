# Rat in a Maze

Find all paths from (0,0) to (n-1,n-1) in an `n x n` binary matrix moving in four directions among free cells (1). A cell cannot be revisited in the same path. Return paths in lexicographic order.

## Approach (Backtracking)
- If start or destination is blocked, return empty.
- DFS with a `visited` matrix; on each step try moves in the fixed order `D, L, R, U` to naturally produce lexicographic order (or sort the result at the end for safety).
- Append the direction to the current path string; backtrack (unmark) on return.

Time: O(4^(n*n)) in worst case (small n ≤ 5), Space: O(n*n) for recursion + visited.
