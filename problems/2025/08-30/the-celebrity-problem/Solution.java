import java.util.*;

public class Solution {
    public static int celebrity(int[][] mat) {
        int n = mat.length;
        if (n == 0) return -1;

        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }

        int cand = i;
        for (int k = 0; k < n; k++) {
            if (k == cand) continue;
            if (mat[cand][k] == 1 || mat[k][cand] == 0) return -1;
        }
        return cand;
    }

    public static void main(String[] args) {
        System.out.println(celebrity(new int[][]{{1,1,0},{0,1,0},{0,1,1}})); // 1
        System.out.println(celebrity(new int[][]{{1,1},{1,1}}));             // -1
        System.out.println(celebrity(new int[][]{{1}}));                     // 0
    }
}


