# maximize /number /of /1s
# Maximize Number of 1's

Given a binary array `arr[]` and integer `k`, flip at most `k` zeroes to 1 to
maximize the length of a consecutive-1s subarray.

**Key idea (sliding window, O(n)):**
Expand a window with `right`, count zeros. If zeros exceed `k`, shrink from
`left` until they’re `<= k`. Track the best window size.

- Time: `O(n)`
- Space: `O(1)`

## Key terms & data structures
- **Sliding window**: maintain a movable subarray with counters.
- **Zero counter**: number of zeros in the current window must be `<= k`.

## Language notes
- **Python**: maintain `zeroes` and move `left` while `zeroes > k`.
- **Java**: use indices and integer counters; avoid extra arrays.
- **JavaScript**: numbers are safe here; remember strict compare when shrinking.
