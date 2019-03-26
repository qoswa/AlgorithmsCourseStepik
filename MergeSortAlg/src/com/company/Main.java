package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int n = in.nextInt();
	int[] array = new int[n];
	for(int i = 0 ; i < n;i++)
	    array[i] = in.nextInt();

    Mergesort sorter = new Mergesort();
    sorter.sort(array);

	for(int i = 0 ; i < array.length; i ++){
        System.out.print(array[i] + " ");
    }

        System.out.println();
        System.out.println(Math.abs(sorter.invers));
    }

}


 class Mergesort {
    private int[] numbers;
    private int[] helper;
    public static long invers;

    public int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }


        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {

            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                invers = invers + (k-j);

                j++;

            }
            k++;


        }

        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;

        }

        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}