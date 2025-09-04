from typing import Optional, List


class Node:
    def __init__(self, d: int):
        self.data = d
        self.next: 'Optional[Node]' = None


class Solution:
    def segregate(self, head: Optional[Node]) -> Optional[Node]:
        if head is None or head.next is None:
            return head

        even_head: Optional[Node] = None
        even_tail: Optional[Node] = None
        odd_head: Optional[Node] = None
        odd_tail: Optional[Node] = None

        curr: Optional[Node] = head
        while curr is not None:
            nxt = curr.next
            curr.next = None
            if (curr.data & 1) == 0:
                if even_head is None:
                    even_head = even_tail = curr
                else:
                    assert even_tail is not None
                    even_tail.next = curr
                    even_tail = curr
            else:
                if odd_head is None:
                    odd_head = odd_tail = curr
                else:
                    assert odd_tail is not None
                    odd_tail.next = curr
                    odd_tail = curr
            curr = nxt

        if even_head is None:
            return odd_head
        assert even_tail is not None
        even_tail.next = odd_head
        return even_head


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

    h = build_list([17, 15, 8, 9, 2, 4, 6])
    h = s.segregate(h)
    print(to_array(h))  # [8, 2, 4, 6, 17, 15, 9]

    h = build_list([1, 3, 5])
    h = s.segregate(h)
    print(to_array(h))  # [1, 3, 5]

    h = build_list([2, 4, 6])
    h = s.segregate(h)
    print(to_array(h))  # [2, 4, 6]
