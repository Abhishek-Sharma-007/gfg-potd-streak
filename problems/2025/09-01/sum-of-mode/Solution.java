import java.util.*;

public class Solution {
    // Helper key: ordered by (-freq, value)
    private static final class Node implements Comparable<Node> {
        final int negFreq; // store -freq so smallest comes first => largest freq
        final int val;

        Node(int negFreq, int val) {
            this.negFreq = negFreq;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.negFreq != o.negFreq) return Integer.compare(this.negFreq, o.negFreq);
            return Integer.compare(this.val, o.val);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return this.negFreq == other.negFreq && this.val == other.val;
        }

        @Override
        public int hashCode() {
            return 31 * negFreq + val;
        }
    }

    public static int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k <= 0 || k > n) return 0;

        Map<Integer, Integer> cnt = new HashMap<>();     // value -> freq in window
        Map<Integer, Node> keyByVal = new HashMap<>();    // value -> Node currently in set
        TreeSet<Node> set = new TreeSet<>();              // ordered by (-freq, value)

        // Build first window
        for (int i = 0; i < k; i++) {
            int v = arr[i];
            int f = cnt.getOrDefault(v, 0);
            if (f > 0) {
                Node old = keyByVal.get(v);
                set.remove(old);
            }
            int nf = f + 1;
            cnt.put(v, nf);
            Node nn = new Node(-nf, v);
            keyByVal.put(v, nn);
            set.add(nn);
        }

        long sum = set.first().val; // mode value of first window

        // Slide the window
        for (int r = k; r < n; r++) {
            int out = arr[r - k];
            int in = arr[r];

            // Remove outgoing
            int fOut = cnt.get(out); // >=1
            Node oldOut = keyByVal.get(out);
            set.remove(oldOut);
            if (fOut == 1) {
                cnt.remove(out);
                keyByVal.remove(out);
            } else {
                int nf = fOut - 1;
                cnt.put(out, nf);
                Node nn = new Node(-nf, out);
                keyByVal.put(out, nn);
                set.add(nn);
            }

            // Add incoming
            int fIn = cnt.getOrDefault(in, 0);
            if (fIn > 0) {
                Node oldIn = keyByVal.get(in);
                set.remove(oldIn);
            }
            int nfIn = fIn + 1;
            cnt.put(in, nfIn);
            Node nnIn = new Node(-nfIn, in);
            keyByVal.put(in, nnIn);
            set.add(nnIn);

            sum += set.first().val; // mode for this window
        }

        return (int) sum; // GFG signature usually returns int
    }

    public static void main(String[] args) {
        System.out.println(sumOfModes(new int[]{1, 2, 3, 2, 5, 2, 4, 4}, 3)); // 13
        System.out.println(sumOfModes(new int[]{1, 2, 1, 3, 5}, 2));          // 6
    }
}


