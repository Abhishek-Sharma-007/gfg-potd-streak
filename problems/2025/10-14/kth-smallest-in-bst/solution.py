class Solution:
    def kthSmallest(self, root, k):
        st = []
        cur = root
        count = 0
        while st or cur:
            while cur:
                st.append(cur)
                cur = cur.left
            cur = st.pop()
            count += 1
            if count == k:
                return cur.data
            cur = cur.right
        return -1
