package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in  = new Scanner(System.in);
	int n = in.nextInt();

	int[] array = new int[n];
	// example input : 10
        // 0 8 4 12 2 10 6 14 1 9
	for(int i = 0; i < n ; i ++){
	    array[i] = in.nextInt();
    }

        int z = longestIncreasingSubsequenceLength(array);
        System.out.println(z);

    }

    private static void LIS(int[] array){
        //finding max length
        int n = array.length;
        int[] d = new int[n];

        for(int i = 0 ; i < n; i ++ ){
            d[i] = 1;

            for(int j = 0 ; j <= i-1;j++){
                if( array[i] % array[j]==0 && d[j] + 1 > d[i]){
                    d[i] = d[j] + 1;
                }
            }

        }
        int[] data = findMax(d);

        // finding sequence
        int max = data[0];
        int index = data[1];
        System.out.println("" + max);
        int length = d[index];
        int value = array[index];
        ArrayList<Integer> m = new ArrayList<>();
        m.add(value);
        while (length>0 && index > -1){
            if(d[index] == length -1 && array[index] < value){
                m.add(array[index]);
                length--;
                value = array[index];
            }
            index--;
        }

//        for(int i = m.size() ; i>0 ;i--){
//            System.out.print(m.get(i-1) + " ");
//        }

    }

    private static int[] findMax(int[] array){
        int index = 0;
        int max = array[0];
        for(int i = 0 ; i < array.length;i++) {
            if (max <= array[i]) {
                max = array[i];
                index = i;
            }
        }
        return new int[]{max,index};
    }
    static int longestIncreasingSubsequenceLength(int numbers[]) {

        if (numbers.length <= 1) {
            return 1;
        }

        int lis_length = -1;

        int subsequence[] = new int[10000000];
        int indexes[] = new int[10000000];

        for (int i = 0; i < numbers.length; ++i) {
            subsequence[i] = 1000000000;
            subsequence[i] = 1000000000;
        }

        subsequence[0] = numbers[0];
        indexes[0] = 0;

        for (int i = 1; i < numbers.length; ++i) {
            indexes[i] = ceilIndex(subsequence, 0, i, numbers[i]);

            if (lis_length < indexes[i]) {
                lis_length = indexes[i];
            }
        }

        return lis_length + 1;
    }

    static int ceilIndex(int subsequence[],
                  int startLeft,
                  int startRight,
                  int key){

        int mid = 0;
        int left = startLeft;
        int right = startRight;
        int ceilIndex = 0;
        boolean ceilIndexFound = false;

        for (mid = (left + right) / 2; left <= right && !ceilIndexFound; mid = (left + right) / 2) {
            if (subsequence[mid] < key) {
                right = mid - 1;
            }
            else if (subsequence[mid] == key) {
                ceilIndex = mid;
                ceilIndexFound = true;
            }
            else if (mid + 1 >= right && subsequence[mid + 1] <= key) {
                subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
                ceilIndexFound = true;
            } else {
                left = mid + 1;
            }
        }

        if (!ceilIndexFound) {
            if (mid == left) {
                subsequence[mid] = key;
                ceilIndex = mid;
            }
            else {
                subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
            }
        }

        return ceilIndex;
    }
}
