# Postorder Traversal

Return the postorder traversal (Left, Right, Node) of a binary tree.

## Approaches
- Recursive DFS (simple, but watch recursion depth for large trees)
- Iterative using one stack and a visited flag or using two stacks

This solution uses a single stack with a pointer to track last visited right subtree.
