import java.util.*;
public class Solution {
    public static int startStation(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
    public static void main(String[] args) {
        System.out.println(startStation(new int[]{4,5,7,4}, new int[]{6,6,3,5})); // 2
        System.out.println(startStation(new int[]{3,9}, new int[]{7,6})); // -1
    }
}


