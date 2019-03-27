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

        LIS(array);

    }

    private static void LIS(int[] array){
        //finding max length
        int n = array.length;
        int[] d = new int[n];

        for(int i = 0 ; i < n; i ++ ){
            d[i] = 1;

            for(int j = 0 ; j < i-1;j++){
                if(array[j]< array[i] && d[j] + 1 > d[i]){
                    d[i] = d[j] + 1;
                }
            }

        }
        int[] data = findMax(d);

        // finding sequence
        int max = data[0];
        int index = data[1];
        System.out.println("Max length:  " + max);
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

        for(int i = m.size() ; i>0 ;i--){
            System.out.print(m.get(i-1) + " ");
        }

    }

    private static int[] findMax(int[] array){
        int index = 0;
        int max = array[0];
        for(int i = 0 ; i < array.length;i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return new int[]{max,index};
    }

}
