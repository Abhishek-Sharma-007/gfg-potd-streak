from typing import Optional, List, Tuple
import heapq


class Node:
    def __init__(self, d: int):
        self.data = d
        self.next: 'Optional[Node]' = None


class Solution:
    def mergeKLists(self, arr: List[Optional[Node]]) -> Optional[Node]:
        # Min-heap of tuples: (value, unique_id, node)
        heap: List[Tuple[int, int, Node]] = []
        push_id = 0
        for head in arr:
            if head is not None:
                heapq.heappush(heap, (head.data, push_id, head))
                push_id += 1

        dummy = Node(0)
        tail = dummy

        while heap:
            val, _, node = heapq.heappop(heap)
            tail.next = node
            tail = node
            if node.next is not None:
                heapq.heappush(heap, (node.next.data, push_id, node.next))
                push_id += 1

        # ensure end terminates
        tail.next = None
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

    lists = [build_list([1, 3, 7]), build_list([2, 4, 8]), build_list([9])]
    h = s.mergeKLists(lists)
    print(to_array(h))  # [1,2,3,4,7,8,9]

    lists = [build_list([1, 3]), build_list([8]), build_list([4, 5, 6])]
    h = s.mergeKLists(lists)
    print(to_array(h))  # [1,3,4,5,6,8]
