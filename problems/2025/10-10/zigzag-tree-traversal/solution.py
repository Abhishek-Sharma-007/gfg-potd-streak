from collections import deque

class Solution:
    def zigZagTraversal(self, root):
        if not root:
            return []
        q = deque([root])
        left_to_right = True
        out = []
        while q:
            size = len(q)
            level = []
            for _ in range(size):
                node = q.popleft()
                level.append(node.data)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if left_to_right:
                out.extend(level)
            else:
                out.extend(reversed(level))
            left_to_right = not left_to_right
        return out
