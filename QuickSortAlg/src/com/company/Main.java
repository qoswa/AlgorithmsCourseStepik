package com.company;

public class Main {

    public static void main(String[] args) {
	int[] array = new int[]{2,-9,32,11,8,0};
	quickSort(array,0,array.length-1);

	for(int i = 0 ; i < array.length;i++)
        System.out.println(array[i]);

    }


    private static void quickSort(int[] array,int start,int end){
        if(start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array,int start,int end){
        int pivot = array[end];
        int pivotIndex = start;
        for (int i = start   ; i < end;i++){
            if(array[i]<= pivot)
            {
                int temp = array[pivotIndex];
                array[pivotIndex] = array[i];
                array[i] = temp;
                pivotIndex ++;
            }
        }

        int temp = array[end];
        array[end] = array[pivotIndex];
        array[pivotIndex] = temp;
        return pivotIndex;
    }
}


