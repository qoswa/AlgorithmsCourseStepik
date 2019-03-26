package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = in.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int z = in.nextInt();
            stringBuilder.append(binarySearch(numbers, z));
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
    }

    private static int binarySearch(int[] array, int k) {
        int l = 1;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == k)
                return m;
            else if (array[m] > k)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

}