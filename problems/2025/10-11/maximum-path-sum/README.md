# Maximum Path Sum

Compute the maximum path sum in a binary tree. A path may start and end at any node.

## Approach (DFS with two values)
For each node, compute:
- `down = max path sum of a path that starts at node and goes down to one side` = `node.val + max(0, left.down, right.down)`
- Update global answer with `node.val + max(0, left.down) + max(0, right.down)` (path passing through node).

Return `down` upward. Initialize global answer as -inf.

Time: O(n), Space: O(h).
