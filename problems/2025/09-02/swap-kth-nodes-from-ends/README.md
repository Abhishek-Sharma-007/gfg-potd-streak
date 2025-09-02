# Swap Kth nodes from ends

Given the head of a singly linked list and an integer `k`, swap the `k`-th node (1-based index) from the beginning with the `k`-th node from the end. Return the head of the final list. If the swap is not possible (`k > n`), return the original list.

## Examples
- List: `1 -> 2 -> 3 -> 4 -> 5`, `k = 1` → `5 -> 2 -> 3 -> 4 -> 1`
- List: `3 -> 10 -> 5 -> 8 -> 9 -> 5`, `k = 2` → `3 -> 9 -> 5 -> 8 -> 10 -> 5`

Constraints: `1 ≤ list size ≤ 1e4`, `1 ≤ node.data ≤ 1e6`, `1 ≤ k ≤ 1e4`.

## Approach (O(n) time, O(1) space)
1. Compute length `n`. If `k > n`, return `head`.
2. Let `i1 = k` (k-th from start), `i2 = n - k + 1` (k-th from end). If `i1 == i2`, nothing to do.
3. Ensure `i1 < i2` to simplify pointer rewiring.
4. Traverse to get `(prev1, node1)` at position `i1` and `(prev2, node2)` at position `i2`.
5. Rewire:
   - If `prev1 != null` set `prev1.next = node2` else `head = node2`.
   - If `prev2 != null` set `prev2.next = node1` else `head = node1`.
   - Swap `node1.next` and `node2.next`.

This works for adjacent nodes and when one of them is the head.

## Why swap nodes (not values)?
Some problems restrict modifying node data. Swapping links preserves node identities and adheres to such constraints.

## Complexity
- Time: `O(n)` — one pass to get `n`, one pass to locate nodes, constant rewiring.
- Space: `O(1)` — just a few pointers.
