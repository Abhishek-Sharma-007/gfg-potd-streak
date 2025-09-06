from typing import Optional, List


class Node:
    def __init__(self, d: int):
        self.data = d
        self.next: 'Optional[Node]' = None


class Solution:
    def countNodesInLoop(self, head: Optional[Node]) -> int:
        if head is None or head.next is None:
            return 0

        slow: Optional[Node] = head
        fast: Optional[Node] = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                # count loop length starting from meeting point
                count = 1
                ptr = slow.next
                while ptr is not slow:
                    count += 1
                    ptr = ptr.next
                return count
        return 0


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


def make_loop(head: Optional[Node], pos_one_based: int) -> Optional[Node]:
    if head is None or pos_one_based <= 0:
        return head
    # connect tail to the node at 1-based index 'pos_one_based'
    loop_node = head
    idx = 1
    while loop_node is not None and idx < pos_one_based:
        loop_node = loop_node.next
        idx += 1
    if loop_node is None:
        return head
    tail = head
    while tail.next is not None:
        tail = tail.next
    tail.next = loop_node
    return head


if __name__ == "__main__":
    s = Solution()

    h = build_list([1, 8, 3, 4])
    h = make_loop(h, 2)  # loop of length 3? depends on structure; just a sanity test
    print(s.countNodesInLoop(h) > 0)

    h = build_list([1, 2, 3, 4, 5])
    h = make_loop(h, 3)
    print(s.countNodesInLoop(h))  # expect 3

    h = build_list([1, 2, 3])
    print(s.countNodesInLoop(h))  # 0
