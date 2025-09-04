class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevTail = dummy;
        Node curr = head;

        while (curr != null) {
            Node lastNodeOfPrevPart = prevTail;
            Node lastNodeOfSublist = curr;

            Node prev = null;
            int i = 0;
            while (curr != null && i < k) {
                Node nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
                i++;
            }

            lastNodeOfPrevPart.next = prev;
            lastNodeOfSublist.next = curr;
            prevTail = lastNodeOfSublist;
        }

        return dummy.next;
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
        Node h = buildList(new int[]{1,2,3,4,5,6});
        h = s.reverseKGroup(h, 2);
        System.out.println(toStringList(h)); // 2,1,4,3,6,5

        h = buildList(new int[]{1,2,3,4,5,6});
        h = s.reverseKGroup(h, 4);
        System.out.println(toStringList(h)); // 4,3,2,1,6,5
    }
}

