# Merge Sort for Linked List

Given the head of a singly linked list, sort it in ascending order using Merge Sort and return the head of the sorted list.

## Examples
- `60 -> 50 -> 40 -> 30 -> 20 -> 10` → `10 -> 20 -> 30 -> 40 -> 50 -> 60`
- `9 -> 2 -> 8 -> 5` → `2 -> 5 -> 8 -> 9`

Constraints: `1 ≤ number of nodes ≤ 1e5`, `0 ≤ node.data ≤ 1e6`.

## Approach (Top-down merge sort)
1. Base case: empty or single-node list is already sorted.
2. Split the list into two halves using slow/fast pointers. Cut at mid.
3. Recursively sort both halves.
4. Merge two sorted lists into one sorted list using a standard linear-time merge.

This approach is preferred for linked lists because splitting and merging can be done without random access, and we avoid the overhead of array conversions.

## Complexity
- Time: `O(n log n)` — recurrence `T(n) = 2T(n/2) + O(n)`.
- Space: `O(log n)` recursion depth (pointer rearrangements are in-place).
