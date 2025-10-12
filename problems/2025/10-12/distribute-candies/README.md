# Distribute Candies in Binary Tree

Each node has some candies; total candies equals number of nodes. In one move, transfer one candy along an edge. Find minimum moves to make every node have exactly one candy.

## Approach (Postorder surplus flow)
For each node, compute surplus = (node.candies - 1) + leftSurplus + rightSurplus.
- Moves needed across this node equals |leftSurplus| + |rightSurplus| (candies flowing in/out to balance children).
- Return `surplus` to parent; accumulate moves globally.

Time: O(n), Space: O(h).
