# Maximum Non-Adjacent Nodes Sum

Select a subset of nodes maximizing sum with the constraint: no two directly connected (parent-child) nodes both chosen.

## Approach (Tree DP: include/exclude)
For each node, compute a pair `(inc, exc)`:
- `inc = node.val + left.exc + right.exc` (choose node → cannot choose children)
- `exc = max(left.inc, left.exc) + max(right.inc, right.exc)` (skip node → children free)

Answer at root is `max(inc, exc)`.

Time: O(n), Space: O(h).
