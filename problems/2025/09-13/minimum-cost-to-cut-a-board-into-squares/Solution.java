import java.util.*;
public class Solution {
    public static long minCostToCutBoard(int[] x, int[] y) {
        Integer[] xi = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] yi = Arrays.stream(y).boxed().toArray(Integer[]::new);
        Arrays.sort(xi, Collections.reverseOrder());
        Arrays.sort(yi, Collections.reverseOrder());
        int i = 0, j = 0;
        long hSegments = 1; // horizontal pieces count
        long vSegments = 1; // vertical pieces count
        long total = 0;
        while (i < xi.length && j < yi.length) {
            if (xi[i] >= yi[j]) {
                total += (long) xi[i] * hSegments;
                vSegments++;
                i++;
            } else {
                total += (long) yi[j] * vSegments;
                hSegments++;
                j++;
            }
        }
        while (i < xi.length) {
            total += (long) xi[i] * hSegments;
            vSegments++;
            i++;
        }
        while (j < yi.length) {
            total += (long) yi[j] * vSegments;
            hSegments++;
            j++;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(minCostToCutBoard(new int[]{2,1,3,1,4}, new int[]{4,1,2})); // 42
        System.out.println(minCostToCutBoard(new int[]{1,1,1}, new int[]{1,1,1}));     // 15
    }
}


