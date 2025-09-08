class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node midPrev = midPrevNode(head);
        Node mid = midPrev.next;
        midPrev.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left, right);
    }

    private Node midPrevNode(Node head) {
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
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
        while (head != null) { sb.append(head.data); head = head.next; if (head != null) sb.append(","); }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node h = buildList(new int[]{60,50,40,30,20,10});
        h = s.mergeSort(h);
        System.out.println(toStringList(h)); // 10,20,30,40,50,60

        h = buildList(new int[]{9,2,8,5});
        h = s.mergeSort(h);
        System.out.println(toStringList(h)); // 2,5,8,9
    }
}
