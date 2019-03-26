package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Heap heap = new Heap();

        for (int i = 0 ; i < n ; i ++){
            String line = reader.readLine();
            if(line.charAt(0) == 'I'){
                int z  = Integer.parseInt(line.substring(7).trim());
                heap.insert(z);
            }
            if (line.charAt(0) == 'E'){
                heap.extractMax();
            }
        }
        heap.showMax();
    }
}

class Heap {
    private int[] array = new int[100000];
    private int n = 0;
    private ArrayList<Integer> maxList = new ArrayList<>();

    public void showMax(){
        for(Integer number : maxList)
            System.out.println(number);
    }
    public void insert(int v){
        n = n + 1;
        array[n] = v;
        siftUp(n);
    }

    public void extractMax(){
        maxList.add(array[1]);
        array[1] = array[n];
        n = n -1 ;
        siftDown(1);
    }

    private void siftUp(int i){
        while (i > 1 && array[i/2] < array[i]){
            int temp = array[i/2];
            array[i/2] = array[i];
            array[i] = temp;
            i = i/2;
        }
    }

    private void siftDown(int i){
        while (2*i <= n){
            int j = i;
            if(array[2*i] > array[j])
                j = 2 * i;
            if(2*i + 1 <= n && array[2*i + 1] > array[j])
                j = 2 * i + 1;
            if ( i == j ) break;

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i = j;
        }
    }

}

