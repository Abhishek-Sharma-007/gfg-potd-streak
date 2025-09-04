# Segregate Even and Odd Nodes in a Linked List

Given the head of a singly linked list, rearrange the nodes so that all nodes with even `data` values appear before nodes with odd `data` values. The relative order among even nodes and among odd nodes must be preserved (stable partition). Return the head of the modified list.

## Examples
- Input: `17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6` → Output: `8 -> 2 -> 4 -> 6 -> 17 -> 15 -> 9`
- Input: `1 -> 3 -> 5` → Output: `1 -> 3 -> 5` (no even nodes)
- Input: `2 -> 4 -> 6` → Output: `2 -> 4 -> 6` (no odd nodes)

Constraints: `1 ≤ size ≤ 1e5`, `0 ≤ node.data ≤ 1e6`.

## Approach (Stable two-list merge, O(n) time, O(1) extra space)
- Traverse the list once, building two chains using tail pointers:
  - Even chain: nodes with `data % 2 == 0`.
  - Odd chain: nodes with `data % 2 == 1`.
- Detach each node from the original list as you go (`curr.next = null`) and append to the appropriate chain tail.
- Finally, connect `evenTail.next = oddHead` and return `evenHead` if it exists, otherwise `oddHead`.

This preserves the original relative order within the even and odd groups.

## Complexity
- Time: `O(n)` — single pass over all nodes.
- Space: `O(1)` — only a few pointer variables.
