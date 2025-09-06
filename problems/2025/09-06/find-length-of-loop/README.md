# Find length of Loop

Given the head of a singly linked list, determine whether it contains a loop. If a loop exists, return the number of nodes in the loop; otherwise return `0`.

Note: Internally, `pos` (1-based) may denote the index of the node that the tail connects to. If `pos = 0`, there is no loop.

## Examples
- `pos = 2` → length of loop is `4`.
- `pos = 3` → loop nodes form a cycle of length `3`.
- `pos = 0` → `0` (no loop).

Constraints: `1 ≤ number of nodes ≤ 1e5`, `1 ≤ node.data ≤ 1e4`, `0 ≤ pos < number of nodes`.

## Approach (Floyd's cycle detection + loop length)
1. Use two pointers: `slow` moves 1 step, `fast` moves 2 steps.
2. If `slow == fast` at any time, a loop exists. To count its length:
   - Keep one pointer at the meeting point.
   - Move the other pointer forward counting steps until it returns to the meeting point.
3. If `fast` or `fast.next` becomes `null`, there is no loop.

This runs in linear time with constant space.

## Complexity
- Time: `O(n)` — each pointer advances linearly.
- Space: `O(1)` — no extra data structures.
