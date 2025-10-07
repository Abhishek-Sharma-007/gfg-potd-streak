from collections import deque

class Solution:
    def bottomView(self, root):
        if not root:
            return []
        q = deque([(root, 0)])
        hd_to_val = {}
        min_hd = max_hd = 0
        while q:
            node, hd = q.popleft()
            hd_to_val[hd] = node.data
            if node.left:
                q.append((node.left, hd - 1))
                if hd - 1 < min_hd:
                    min_hd = hd - 1
            if node.right:
                q.append((node.right, hd + 1))
                if hd + 1 > max_hd:
                    max_hd = hd + 1
        return [hd_to_val[h] for h in range(min_hd, max_hd + 1)]
