from typing import Optional, List


class Node:
    def __init__(self, x: int):
        self.data = x
        self.next: 'Optional[Node]' = None


class Solution:
    def swapKth(self, head: Optional[Node], k: int) -> Optional[Node]:
        if head is None or k <= 0:
            return head

        # 1) Find length n
        n = 0
        t = head
        while t is not None:
            n += 1
            t = t.next
        if k > n:
            return head

        i1 = k
        i2 = n - k + 1
        if i1 == i2:
            return head
        if i1 > i2:
            i1, i2 = i2, i1

        # 2) Find (prev1, node1) and (prev2, node2)
        prev1: Optional[Node] = None
        node1: Optional[Node] = head
        for _ in range(1, i1):
            prev1 = node1
            node1 = node1.next if node1 else None

        prev2: Optional[Node] = None
        node2: Optional[Node] = head
        for _ in range(1, i2):
            prev2 = node2
            node2 = node2.next if node2 else None

        if node1 is None or node2 is None:
            return head

        # 3) Rewire previous pointers
        if prev1 is not None:
            prev1.next = node2
        else:
            head = node2
        if prev2 is not None:
            prev2.next = node1
        else:
            head = node1

        # 4) Swap next pointers
        temp = node1.next
        node1.next = node2.next
        node2.next = temp

        return head


# Helpers for quick checks

def build_list(values: List[int]) -> Optional[Node]:
    head: Optional[Node] = None
    tail: Optional[Node] = None
    for v in values:
        n = Node(v)
        if head is None:
            head = tail = n
        else:
            assert tail is not None
            tail.next = n
            tail = n
    return head


def to_array(head: Optional[Node]) -> List[int]:
    out: List[int] = []
    while head is not None:
        out.append(head.data)
        head = head.next
    return out


if __name__ == "__main__":
    s = Solution()

    h = build_list([1, 2, 3, 4, 5])
    h = s.swapKth(h, 1)
    print(to_array(h))  # [5, 2, 3, 4, 1]

    h = build_list([3, 10, 5, 8, 9, 5])
    h = s.swapKth(h, 2)
    print(to_array(h))  # [3, 9, 5, 8, 10, 5]
