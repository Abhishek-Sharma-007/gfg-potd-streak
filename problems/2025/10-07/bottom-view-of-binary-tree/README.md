# Bottom View of Binary Tree

Compute the bottom view: for each horizontal distance (hd) from root, report the node seen last in level order (deepest/rightmost in BFS per hd).

## Approach (BFS with hd)
- BFS with pairs (node, hd), where root has hd=0; left child hd-1, right child hd+1.
- Maintain a map hd→value; overwrite on each visit so later nodes at same hd replace earlier ones (satisfying "latter in level order").
- Track minHd and maxHd; after BFS, emit values from minHd..maxHd.

Time: O(n), Space: O(n).
