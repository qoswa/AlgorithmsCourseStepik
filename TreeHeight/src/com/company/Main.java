package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            outer.add(new ArrayList<>());
        }

        int root = -1;
        for(int i = 0 ; i < n;i++){
            int nextInt = scanner.nextInt();
            if(nextInt != -1) {
                outer.get(nextInt).add(i);
            } else
                root = i;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>(outer.get(root));
        int deep = 0;
        while (!queue.isEmpty()){
            int queLength = queue.size();
            ArrayList<Integer> indexes = new ArrayList<>();
            for(int i = 0 ; i < queLength;i++){
                indexes.add(queue.poll());
            }

            for(int i = 0 ; i < indexes.size();i++){
                int size = outer.get(indexes.get(i)).size();
                for(int j = 0 ; j < size;j++){
                    queue.push(outer.get(indexes.get(i)).get(j));
                }
            }
            deep++;
        }
        System.out.println(++deep);
        }
    }

