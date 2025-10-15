# k-th Smallest in BST

Find the k-th smallest element in a BST.

## Approach (Iterative inorder)
- Inorder traversal of BST yields nodes in ascending order.
- Use a stack to simulate recursion; push left spine, pop nodes counting up to `k`, then go right.
- If fewer than `k` nodes exist, return -1.

Time: O(h + k), Space: O(h).
