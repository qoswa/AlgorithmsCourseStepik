package com.company;

public class Main {

    public static void main(String[] args) {

        int[] massiv = new int[] {2,3,5,1,-9,3,-3,25,0,-4};
        insertionSort(massiv);
        for (int i1 : massiv) {
            System.out.println(i1);
        }
    }


    private static void insertionSort(int[] array){
        int n = array.length;
        for(int i = 1 ; i < n;i ++){
            int j = i;
            while(j>0 && array[j]< array[j-1]){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }

}
