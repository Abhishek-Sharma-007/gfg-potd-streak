# Longest Subarray Length

Given `arr[]`, find the maximum length `L` of a subarray such that every element in that subarray is `<= L`.

Observation: For any subarray, the condition depends only on its maximum. A subarray of length `L` is valid iff `max(subarray) <= L`.

## Approach (Next Greater to left/right)
For each index `i`, compute the span where `arr[i]` is the maximum by finding:
- `leftGreater[i]`: nearest index to the left with value `> arr[i]` (or `-1` if none)
- `rightGreater[i]`: nearest index to the right with value `> arr[i]` (or `n` if none)

Then the maximal subarray where `arr[i]` is the maximum has length:
`span = rightGreater[i] - leftGreater[i] - 1`.
If `span >= arr[i]`, then taking that span is a valid subarray (all values `<= arr[i] <= span`). The answer is the maximum such `span` across all `i` (or `0` if none).

Time: O(n), Space: O(n).
