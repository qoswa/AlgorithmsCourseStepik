package com.company;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sourceNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            sourceNumbers[i] = in.nextInt();
        }
        in.close();
        countingSort(sourceNumbers, 10);
        for (int i = 0; i < n; i++) {
            System.out.print(sourceNumbers[i] + " ");
        }

    }

    public static void countingSort(int[] arr, int max) {
        int i, j, b = 0;
        int[] c = new int[max+1];
        for (i = 0; i <=max; i++)  c[i] = 0;
        for (i = 0; i < arr.length; i++) {
            c[arr[i]] = c[arr[i]] + 1;
            b = 0;
        }
        for (j = 0; j <= max; j++) {
            for (i = 0; i < c[j]; i++) {
                arr[b] = j;
                b = b + 1;
            }
        }
    }
}