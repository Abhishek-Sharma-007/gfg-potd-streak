# Max of min for every window size

For each window size `k` (1..n), compute the maximum among the minimums of all subarrays of length `k`.

## Approach (prev/next smaller + sweep)
- For each index `i`, find:
  - `prevSmaller[i]`: previous index with value < `arr[i]` (strict)
  - `nextSmaller[i]`: next index with value < `arr[i]` (strict)
- The element `arr[i]` is the minimum for windows of length `len = nextSmaller[i] - prevSmaller[i] - 1`.
- Maintain `res[len] = max(res[len], arr[i])` over all `i`.
- Post-process from large to small `k`: `res[k-1] = max(res[k-1], res[k])` to fill gaps (larger windows can use best of larger lengths).

Time: O(n), Space: O(n).
