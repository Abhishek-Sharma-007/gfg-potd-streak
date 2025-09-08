from typing import Optional, List


class Node:
    def __init__(self, d: int):
        self.data = d
        self.next: 'Optional[Node]' = None


class Solution:
    def sortList(self, head: Optional[Node]) -> Optional[Node]:
        return self._merge_sort(head)

    def _merge_sort(self, head: Optional[Node]) -> Optional[Node]:
        if head is None or head.next is None:
            return head

        mid_prev = self._mid_prev(head)
        assert mid_prev is not None
        mid = mid_prev.next
        mid_prev.next = None

        left = self._merge_sort(head)
        right = self._merge_sort(mid)
        return self._merge(left, right)

    def _mid_prev(self, head: Node) -> Optional[Node]:
        slow: Node = head
        fast: Node = head
        prev: Optional[Node] = None
        while fast is not None and fast.next is not None:
            prev = slow
            slow = slow.next  # type: ignore
            fast = fast.next.next
        return prev

    def _merge(self, a: Optional[Node], b: Optional[Node]) -> Optional[Node]:
        dummy = Node(0)
        tail = dummy
        while a is not None and b is not None:
            if a.data <= b.data:
                tail.next = a
                a = a.next
            else:
                tail.next = b
                b = b.next
            tail = tail.next
        tail.next = a if a is not None else b
        return dummy.next


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

    h = build_list([60, 50, 40, 30, 20, 10])
    h = s.sortList(h)
    print(to_array(h))  # [10,20,30,40,50,60]

    h = build_list([9, 2, 8, 5])
    h = s.sortList(h)
    print(to_array(h))  # [2,5,8,9]
