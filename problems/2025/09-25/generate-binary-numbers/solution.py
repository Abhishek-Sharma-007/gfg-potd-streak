from collections import deque

class Solution:
    def generateBinary(self, n: int):
        res = []
        q = deque(["1"])
        for _ in range(n):
            s = q.popleft()
            res.append(s)
            q.append(s + "0")
            q.append(s + "1")
        return res

if __name__ == "__main__":
    print(Solution().generateBinary(4))  # ["1","10","11","100"]
