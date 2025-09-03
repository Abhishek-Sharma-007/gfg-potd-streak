# Reverse a Doubly Linked List

Given the head of a doubly linked list, reverse it and return the head of the reversed list.

## Examples
- Input: `3 <-> 4 <-> 5` → Output: `5 <-> 4 <-> 3`
- Input: `75 <-> 122 <-> 59 <-> 196` → Output: `196 <-> 59 <-> 122 <-> 75`

Constraints: `1 ≤ number of nodes ≤ 1e6`, `0 ≤ node.data ≤ 1e4`.

## Approach (O(n) time, O(1) space)
Iterate through the list and swap the `prev` and `next` pointers for each node. After swapping, move to the node that is now in `prev` (which was originally `next`). At the end, the new head is `temp.prev` (where `temp` holds the previous `prev` reference of the last processed node).

Steps:
1. Handle edge cases: empty list or single node → return `head`.
2. For each node `curr`:
   - `temp = curr.prev`
   - `curr.prev = curr.next`
   - `curr.next = temp`
   - `curr = curr.prev`  (originally `curr.next`)
3. After the loop, if `temp != null`, set `head = temp.prev`.

This correctly reverses all links in-place and runs in linear time.

## Complexity
- Time: `O(n)` — touch each node once.
- Space: `O(1)` — constant extra pointers.
