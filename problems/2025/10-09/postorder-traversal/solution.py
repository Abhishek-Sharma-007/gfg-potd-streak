class Solution:
    def postOrder(self, root):
        if not root:
            return []
        s1 = [root]
        s2 = []
        while s1:
            node = s1.pop()
            s2.append(node.data)
            if node.left:
                s1.append(node.left)
            if node.right:
                s1.append(node.right)
        return s2[::-1]
