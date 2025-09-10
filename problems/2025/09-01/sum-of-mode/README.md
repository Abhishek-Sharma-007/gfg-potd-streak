# Sum of Mode

Given an array `arr[]` of positive integers and an integer `k`, find the sum of the modes of all subarrays of size `k`.

Note: The mode of a subarray is the element with the highest frequency; if multiple elements share the highest frequency, the smallest such element is the mode.

## Examples
- `arr = [1, 2, 3, 2, 5, 2, 4, 4]`, `k = 3` → modes per window: `[1, 2, 2, 2, 2, 4]`, sum = `13`.
- `arr = [1, 2, 1, 3, 5]`, `k = 2` → modes per window: `[1, 1, 1, 3]`, sum = `6`.

Constraints: `1 ≤ k ≤ n ≤ 1e5`, `1 ≤ arr[i] ≤ 1e5`.

## Optimized approach (Sliding window + ordered structure)
- Maintain a sliding window of size `k` and a frequency map `cnt[value]`.
- We must query the mode quickly: highest frequency, tie-broken by smallest value.
- Efficient structures:
  - Java: `TreeSet<Node>` where `Node` is ordered by `(-freq, value)`; update by removing the old node and inserting the new one per value.
  - Python/JS: min-heap of pairs `(-freq, value)` with lazy deletion (verify top against current `cnt`).

Each step updates two values (outgoing and incoming) in `O(log m)` where `m` is distinct values in the window (`m ≤ k`), and retrieves the mode in `O(1)` amortized.

Time: `O(n log k)`. Space: `O(k)`.

## Key terms & data structures
- **Mode with tie-break**: max frequency, smallest value on ties.
- **Lazy heap deletion**: ignore stale heap entries whose frequency no longer matches `cnt`.
- **Ordered set** (Java): keeps pairs ordered for `O(log k)` updates and `O(1)` mode.

## Language notes
- **Python**: `heapq` is a min-heap; push `(-freq, value)` and validate top with `cnt`.
- **Java**: `TreeSet` with custom `Comparable` node; remove-before-update pattern to maintain order.
- **JavaScript**: implement a binary heap with `[-freq, value]` pairs and lazy deletion.


