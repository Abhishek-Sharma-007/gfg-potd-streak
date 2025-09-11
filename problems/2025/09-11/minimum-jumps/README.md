# Minimum Jumps

Given an array `arr[]` of non-negative integers, where `arr[i]` denotes the maximum steps you can jump forward from index `i`, find the minimum number of jumps to reach the last index. Return `-1` if the end cannot be reached.

## Examples
- `[1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]` → `3`
- `[1, 4, 3, 2, 6, 7]` → `2`
- `[0, 10, 20]` → `-1`

Constraints: `2 ≤ n ≤ 1e5`, `0 ≤ arr[i] ≤ 1e5`.

## Approach (Greedy window expansion, O(n) time / O(1) space)
Maintain a "current layer" of reachable indices using two variables:
- `farthest`: the farthest index reachable within the current window.
- `end`: the boundary of the current window.
- `jumps`: number of jumps taken to expand windows.

Scan from left to right (up to `n-2` since we don't need to expand beyond last):
1. If `i > farthest`, return `-1` (cannot reach `i`).
2. Update `farthest = max(farthest, i + arr[i])`.
3. When `i == end`, we must take a jump to move to the next window: `jumps++`, and set `end = farthest`.
4. If `end >= n-1`, we can reach the end; return `jumps`.

Edge cases:
- If `arr[0] == 0` and `n > 1`, return `-1`.
- Single step arrays are covered by the loop logic.

## Complexity
- Time: `O(n)` — each index processed once.
- Space: `O(1)` — few integers.

## Key terms & data structures
- **Greedy layer/window**: treat indices within `[prevEnd+1 .. end]` as one jump layer.
- **Farthest reach**: best next boundary after one more jump.

## Language notes
- **Python**: iterate with `range(n-1)`; return early when `end >= n-1`.
- **Java**: careful with integer indices; handle `arr.length == 0/1` fast path.
- **JavaScript**: arrays are dynamic; use simple numeric variables for `end`/`farthest`.
