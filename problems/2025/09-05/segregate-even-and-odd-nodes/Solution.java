class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {
    public Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node curr = head;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = null;
            if ((curr.data & 1) == 0) {
                if (evenHead == null) { evenHead = evenTail = curr; }
                else { evenTail.next = curr; evenTail = curr; }
            } else {
                if (oddHead == null) { oddHead = oddTail = curr; }
                else { oddTail.next = curr; oddTail = curr; }
            }
            curr = nxt;
        }

        if (evenHead == null) return oddHead;
        evenTail.next = oddHead;
        return evenHead;
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

    private static String toStringList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            head = head.next;
            if (head != null) sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node h = buildList(new int[]{17,15,8,9,2,4,6});
        h = s.segregate(h);
        System.out.println(toStringList(h)); // 8,2,4,6,17,15,9

        h = buildList(new int[]{1,3,5});
        h = s.segregate(h);
        System.out.println(toStringList(h)); // 1,3,5

        h = buildList(new int[]{2,4,6});
        h = s.segregate(h);
        System.out.println(toStringList(h)); // 2,4,6
    }
}
