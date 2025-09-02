class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null || k <= 0) return head;

        // 1) Find length n
        int n = 0;
        for (Node t = head; t != null; t = t.next) n++;
        if (k > n) return head;

        int i1 = k;
        int i2 = n - k + 1;
        if (i1 == i2) return head;
        if (i1 > i2) { int tmp = i1; i1 = i2; i2 = tmp; }

        // 2) Locate (prev1, node1)
        Node prev1 = null, node1 = head;
        for (int i = 1; i < i1; i++) { prev1 = node1; node1 = node1.next; }

        // Locate (prev2, node2)
        Node prev2 = null, node2 = head;
        for (int i = 1; i < i2; i++) { prev2 = node2; node2 = node2.next; }

        // 3) Rewire prev pointers
        if (prev1 != null) prev1.next = node2; else head = node2;
        if (prev2 != null) prev2.next = node1; else head = node1;

        // 4) Swap next pointers
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;

        return head;
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
        Node h = buildList(new int[]{1,2,3,4,5});
        h = s.swapKth(h, 1);
        System.out.println(toStringList(h)); // 5,2,3,4,1

        h = buildList(new int[]{3,10,5,8,9,5});
        h = s.swapKth(h, 2);
        System.out.println(toStringList(h)); // 3,9,5,8,10,5
    }
}
