# Linked List Group Reverse

Given the head of a singly linked list, reverse every `k` nodes and return the head of the modified list. If the final group has fewer than `k` nodes, it is still reversed (i.e., all groups are reversed, including the last short group).

## Examples
- k = 2: `1 -> 2 -> 3 -> 4 -> 5 -> 6` → `2 -> 1 -> 4 -> 3 -> 6 -> 5`
- k = 4: `1 -> 2 -> 3 -> 4 -> 5 -> 6` → `4 -> 3 -> 2 -> 1 -> 6 -> 5`

Constraints: `1 ≤ size ≤ 1e5`, `0 ≤ node.data ≤ 1e6`, `1 ≤ k ≤ size`.

## Approach (Iterative, O(n) time / O(1) extra space)
We reverse the list in-place group by group using pointer manipulation:
1. Use a dummy node pointing to `head` and maintain `prevTail` as the tail of the previously reversed group (initially dummy).
2. For each group starting at `curr`, reverse up to `k` nodes (or until the list ends) by standard in-place reversal.
3. Connect `prevTail.next` to the new head of this reversed group and connect the new tail to the next group's head.
4. Advance `prevTail` to the tail of the reversed group and continue until the end.

Because the problem requires reversing even the final short group, we do not skip reversal when fewer than `k` nodes remain.

## Complexity
- Time: `O(n)` — each node is visited and re-linked once.
- Space: `O(1)` — uses a few pointers.

