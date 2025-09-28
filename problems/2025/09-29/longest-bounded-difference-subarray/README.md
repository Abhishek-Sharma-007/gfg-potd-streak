# Longest Bounded-Difference Subarray

Given `arr[]` and `x ≥ 0`, find the longest subarray such that `max(subarray) - min(subarray) ≤ x`. If multiple, return the one with the smallest starting index.

## Approach (Sliding window + monotonic deques)
Maintain a window [l..r] and two deques of indices:
- `maxDQ`: decreasing by value (front holds index of window max)
- `minDQ`: increasing by value (front holds index of window min)

For each `r`:
- Push `r` into both deques while maintaining their monotonic property.
- While `arr[maxDQ[0]] - arr[minDQ[0]] > x`, increment `l` and pop front indices that fall left of `l`.
- Track the best window length; prefer earlier `l` on ties.

Time: O(n), Space: O(n).
