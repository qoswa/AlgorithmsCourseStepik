package com.company;

import java.util.HashMap;
import java.util.Map;

class Node {

    public static Map<Character,String> result = new HashMap<>();
    Node left;
    Node right;
    public Character value;
    public int priority;
    public  String code = "";

    public Node(Character value,int priority,Node left,Node right) {
        this.value = value;
        this.left = left;
        this.priority = priority;
        this.right = right;
    }

    public Node(Character value,int priority){
        this.value = value;
        this.priority = priority;
    }

    void recPreOrder(){

        if (left!=null) {
            left.code = code + "0";
            if(left.value!=null){
                result.put(left.value,left.code);

            }
            left.recPreOrder();
        }
        if (right!=null){
            right.code = code + "1";
            if(right.value != null){
                result.put(right.value,right.code);
            }
            right.recPreOrder();
        }

    }
}