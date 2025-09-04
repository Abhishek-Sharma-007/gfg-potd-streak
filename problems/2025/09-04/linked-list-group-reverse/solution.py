from typing import Optional, List


class Node:
    def __init__(self, key: int):
        self.data = key
        self.next: 'Optional[Node]' = None


class Solution:
    def reverseKGroup(self, head: Optional[Node], k: int) -> Optional[Node]:
        if head is None or k <= 1:
            return head

        dummy = Node(0)
        dummy.next = head
        prev_tail: Node = dummy
        curr: Optional[Node] = head

        while curr is not None:
            last_node_of_prev_part: Node = prev_tail
            last_node_of_sublist: Node = curr

            prev: Optional[Node] = None
            i = 0
            # reverse up to k nodes (or remaining nodes if < k)
            while curr is not None and i < k:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
                i += 1

            # connect the previous part with the reversed sublist
            last_node_of_prev_part.next = prev
            # connect the tail of this sublist to the next group's head
            last_node_of_sublist.next = curr
            # move prev_tail to the tail of this reversed group
            prev_tail = last_node_of_sublist

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

    h = build_list([1, 2, 3, 4, 5, 6])
    h = s.reverseKGroup(h, 2)
    print(to_array(h))  # [2, 1, 4, 3, 6, 5]

    h = build_list([1, 2, 3, 4, 5, 6])
    h = s.reverseKGroup(h, 4)
    print(to_array(h))  # [4, 3, 2, 1, 6, 5]

