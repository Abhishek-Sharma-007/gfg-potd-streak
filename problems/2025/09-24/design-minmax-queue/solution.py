from collections import deque

class SpecialQueue:
    def __init__(self):
        self.q = deque()
        self.minq = deque()
        self.maxq = deque()

    def enqueue(self, x: int) -> None:
        self.q.append(x)
        while self.minq and self.minq[-1] > x:
            self.minq.pop()
        self.minq.append(x)
        while self.maxq and self.maxq[-1] < x:
            self.maxq.pop()
        self.maxq.append(x)

    def dequeue(self) -> None:
        x = self.q.popleft()
        if self.minq and self.minq[0] == x:
            self.minq.popleft()
        if self.maxq and self.maxq[0] == x:
            self.maxq.popleft()

    def getFront(self) -> int:
        return self.q[0]

    def getMin(self) -> int:
        return self.minq[0]

    def getMax(self) -> int:
        return self.maxq[0]

if __name__ == "__main__":
    sq = SpecialQueue()
    for op in [(1,4),(1,2),(3,),(4,),(2,),(5,)]:
        if op[0] == 1: sq.enqueue(op[1])
        elif op[0] == 2: sq.dequeue()
        elif op[0] == 3: print(sq.getFront())
        elif op[0] == 4: print(sq.getMin())
        else: print(sq.getMax())
