from typing import Optional, List


class Node:
    def __init__(self, data: int):
        self.data = data
        self.next: 'Optional[Node]' = None
        self.prev: 'Optional[Node]' = None


class Solution:
    def reverse(self, head: Optional[Node]) -> Optional[Node]:
        if head is None or head.next is None:
            return head

        curr = head
        temp: Optional[Node] = None

        # Swap prev and next for every node
        while curr is not None:
            temp = curr.prev
            curr.prev = curr.next
            curr.next = temp
            # move to the new prev (originally next)
            curr = curr.prev

        # temp is at the node before new head
        if temp is not None:
            head = temp.prev

        return head


# Helpers for quick checks

def build_dll(values: List[int]) -> Optional[Node]:
    head: Optional[Node] = None
    prev: Optional[Node] = None
    for v in values:
        n = Node(v)
        if head is None:
            head = n
        if prev is not None:
            prev.next = n
            n.prev = prev
        prev = n
    return head


def to_array(head: Optional[Node]) -> List[int]:
    out: List[int] = []
    while head is not None:
        out.append(head.data)
        head = head.next
    return out


if __name__ == "__main__":
    s = Solution()

    h = build_dll([3, 4, 5])
    h = s.reverse(h)
    print(to_array(h))  # [5, 4, 3]

    h = build_dll([75, 122, 59, 196])
    h = s.reverse(h)
    print(to_array(h))  # [196, 59, 122, 75]
