class Solution:
    def getMaxSum(self, root):
        def dfs(node):
            if not node:
                return (0, 0)  # inc, exc
            li, le = dfs(node.left)
            ri, re = dfs(node.right)
            inc = node.data + le + re
            exc = max(li, le) + max(ri, re)
            return (inc, exc)
        inc, exc = dfs(root)
        return max(inc, exc)
