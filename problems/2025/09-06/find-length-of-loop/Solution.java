class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {
    public int countNodesInLoop(Node head) {
        if (head == null || head.next == null) return 0;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                Node ptr = slow.next;
                while (ptr != slow) { count++; ptr = ptr.next; }
                return count;
            }
        }
        return 0;
    }

    // Helpers for quick checks
    private static Node buildList(int[] arr) {
        Node head = null, tail = null;
        for (int v : arr) {
            Node n = new Node(v);
            if (head == null) { head = tail = n; }
            else { tail.next = n; tail = n; }
        }
        return head;
    }

    private static Node makeLoop(Node head, int posOneBased) {
        if (head == null || posOneBased <= 0) return head;
        Node loopNode = head; int idx = 1;
        while (loopNode != null && idx < posOneBased) { loopNode = loopNode.next; idx++; }
        if (loopNode == null) return head;
        Node tail = head; while (tail.next != null) tail = tail.next;
        tail.next = loopNode;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node h = buildList(new int[]{1,2,3,4,5});
        h = makeLoop(h, 3);
        System.out.println(s.countNodesInLoop(h)); // 3

        h = buildList(new int[]{10,20,30});
        System.out.println(s.countNodesInLoop(h)); // 0
    }
}
