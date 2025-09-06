import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class Solution {
    public Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));
        for (Node head : arr) if (head != null) pq.add(head);

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) pq.add(node.next);
        }

        tail.next = null;
        return dummy.next;
    }

    // Helpers for quick checks
    private static Node buildList(int[] a) {
        Node head = null, tail = null;
        for (int v : a) {
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
        Node[] lists = new Node[]{ buildList(new int[]{1,3,7}), buildList(new int[]{2,4,8}), buildList(new int[]{9}) };
        Node h = s.mergeKLists(lists);
        System.out.println(toStringList(h)); // 1,2,3,4,7,8,9

        lists = new Node[]{ buildList(new int[]{1,3}), buildList(new int[]{8}), buildList(new int[]{4,5,6}) };
        h = s.mergeKLists(lists);
        System.out.println(toStringList(h)); // 1,3,4,5,6,8
    }
}
