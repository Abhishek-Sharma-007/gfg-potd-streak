class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        Node temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; // move to new prev (originally next)
        }

        if (temp != null) head = temp.prev;
        return head;
    }

    // Helpers for quick checks
    private static Node buildDLL(int[] arr) {
        Node head = null, prev = null;
        for (int v : arr) {
            Node n = new Node(v);
            if (head == null) head = n;
            if (prev != null) { prev.next = n; n.prev = prev; }
            prev = n;
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
        Node h = buildDLL(new int[]{3,4,5});
        h = s.reverse(h);
        System.out.println(toStringList(h)); // 5,4,3

        h = buildDLL(new int[]{75,122,59,196});
        h = s.reverse(h);
        System.out.println(toStringList(h)); // 196,59,122,75
    }
}
