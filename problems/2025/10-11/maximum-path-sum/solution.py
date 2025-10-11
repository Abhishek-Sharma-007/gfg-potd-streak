class Solution:
    def findMaxSum(self, root):
        self.best = float('-inf')
        def dfs(node):
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            # best path through this node
            through = node.data + max(0, left) + max(0, right)
            if through > self.best:
                self.best = through
            # return best downward path from this node
            return node.data + max(0, left, right)
        dfs(root)
        return int(self.best)
