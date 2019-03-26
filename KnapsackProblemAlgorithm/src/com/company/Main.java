package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Item> stolenItems = new ArrayList<>();
        int n = in.nextInt();
        double w = in.nextDouble();

        for(int i = 0 ; i < n;i++){
            items.add(new Item(in.nextDouble(),in.nextDouble()));
        }

        items.sort((item, t1) -> Double.compare(t1.pTw,item.pTw));

//        for(int i = 0 ; i < n ; i++){
//            System.out.println("Item " + i + " price: " + items.get(i).getPrice() + " weight: " + items.get(i).getWeight()
//            + " ptw: " + items.get(i).getpTw());
//        }

        double totalPrice = 0.0;
        int i = 0;
        while (w != 0 && i < n){
            if(w >= items.get(i).weight){
                totalPrice = totalPrice + (items.get(i).getpTw()*items.get(i).getWeight());
                w = w - items.get(i).weight;
            } else {
                totalPrice = totalPrice + w * items.get(i).getpTw();
                w = 0;
            }

            i++;
        }


        System.out.printf("%.3f",  totalPrice);

    }


    public static class Item{
        double price;
        double weight;
        double pTw;
        public Item(double price,double weight){
            this.price = price;
            this.weight = weight;
            pTw = price / weight;
        }

        public double getPrice() {
            return price;
        }

        public double getWeight() {
            return weight;
        }

        public double getpTw() {
            return pTw;
        }
    }
}
