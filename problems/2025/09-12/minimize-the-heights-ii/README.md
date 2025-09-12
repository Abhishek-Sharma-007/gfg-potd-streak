# Minimize the Heights II

Given an array `arr[]` of tower heights and an integer `k`, for each tower you must either increase it by `k` or decrease it by `k` exactly once. Find the minimum possible difference between the tallest and the shortest tower after the modifications. Resulting heights must not be negative.

## Approach (Greedy after sorting)
1. Sort the array.
2. Initial answer is `arr[n-1] - arr[0]` (no change baseline).
3. Let `small = arr[0] + k` and `big = arr[n-1] - k`; swap if `small > big`.
4. For each middle index `i` from `1` to `n-2`:
   - `decrease = arr[i] - k`, `increase = arr[i] + k`; skip if `decrease < 0`.
   - New min = `min(small, decrease)`, new max = `max(big, increase)`.
   - Update answer with the smaller of current and `(new max - new min)`.

This assigns some towers `+k` and others `-k` to shrink the range while keeping heights non-negative.

**Time:** O(n log n) due to sorting, **Space:** O(1) extra.


