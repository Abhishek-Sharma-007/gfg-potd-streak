from collections import deque

class Solution:
    def reverseQueue(self, q: deque) -> None:
        st = []
        while q:
            st.append(q.popleft())
        while st:
            q.append(st.pop())

if __name__ == "__main__":
    from collections import deque
    q = deque([5,10,15,20,25])
    Solution().reverseQueue(q)
    print(list(q))  # [25,20,15,10,5]
