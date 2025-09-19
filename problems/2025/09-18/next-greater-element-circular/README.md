# Next Greater Element in Circular Array

Given a circular array `arr`, for each index `i` find the first element strictly greater than `arr[i]` when traversing forward circularly. If none, return -1 for that index.

## Approach (Monotonic stack, traverse twice)
- Let `n = len(arr)`. Initialize `ans` with -1s and an empty stack of indices.
- Traverse indices `i` from `2n-1` down to `0` (use `i % n` to index the array):
  - While stack not empty and `arr[stack.top] <= arr[i % n]`, pop.
  - If `i < n` and stack not empty, set `ans[i] = arr[stack.top]`.
  - Push `i % n`.
This effectively sees next greater considering wrap-around.

Time: O(n), Space: O(n).

