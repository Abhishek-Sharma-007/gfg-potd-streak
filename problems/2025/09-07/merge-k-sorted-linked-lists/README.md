# Merge K Sorted Linked Lists

Given an array of `k` sorted singly linked lists, merge them into a single sorted linked list and return its head.

## Examples
- Lists: `[1 -> 3 -> 7]`, `[2 -> 4 -> 8]`, `[9]` → Merged: `1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9`
- Lists: `[1 -> 3]`, `[8]`, `[4 -> 5 -> 6]` → Merged: `1 -> 3 -> 4 -> 5 -> 6 -> 8`

Constraints: `1 ≤ total nodes ≤ 1e5`, `1 ≤ node.data ≤ 1e3`.

## Approach 1: Min-heap (Priority Queue) — O(N log k), O(k) space
- Push the head of each non-empty list into a min-heap keyed by node value.
- Repeat: pop the smallest node, append it to the merged list, and push its `next` if present.
- Continue until the heap is empty.

This is optimal for many small lists and guarantees overall `O(N log k)` time where `N` is total nodes.

## Approach 2: Divide and Conquer — O(N log k), O(1) extra (excluding recursion)
- Repeatedly merge pairs of lists (like merge sort): merge lists `0&1`, `2&3`, etc., then repeat on resulting lists until one remains.

This reduces heap overhead and can be efficient when merges are large and fewer.

## Chosen Implementation
We implement the min-heap approach in Python/JavaScript/Java for clarity and performance with many lists.

## Complexity
- Time: `O(N log k)`
- Space: `O(k)` for the heap

## Key terms & data structures
- **Min-heap/PriorityQueue**: retrieve minimum head among `k` lists in `O(log k)`.
- **Dummy head**: simplifies tail appending during merge.

## Language notes
- **Python**: `heapq` with tuples `(value, tieBreaker, node)` to avoid comparing nodes.
- **Java**: `PriorityQueue<Node>` with comparator `n -> n.data`.
- **JavaScript**: implement a binary heap; compare by `.data`.
