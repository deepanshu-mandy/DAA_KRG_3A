// 0-1 Knapsack Problem using Dynamic Programming

import java.util.Scanner;

public class Knapsack01 {

    static int knapSack(int capacity, int[] weight, int[] value, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        System.out.print("Enter values of items: ");
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        System.out.print("Enter weights of items: ");
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int maxValue = knapSack(capacity, weight, value, n);
        System.out.println("Maximum value that can be obtained: " + maxValue);

        sc.close();
    }
}
