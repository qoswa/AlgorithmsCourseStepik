package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args)  {
        System.out.print("Enter your line: ");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Map<Character,Integer> count = new HashMap<>();


        for(int i = 0 ; i < line.toCharArray().length ; i ++){
            char c = line.charAt(i);
            if(count.containsKey(c)){
                count.put(c,count.get(c) + 1);
            } else {
                count.put(c, 1);

            }
        }

       Set<Character> set = count.keySet();
        ArrayList<Node> nodes = new ArrayList<>();

        for(Character c : set)
            nodes.add(new Node(c,count.get(c)));

        while(nodes.size()>1){
            nodes.sort(Comparator.comparingInt(node -> node.priority));
            Node one = nodes.get(0);
            Node two = nodes.get(1);
            Node newNode = new Node(null,one.priority + two.priority,one,two);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(newNode);
        }

        boolean ifStrUniq;
        ifStrUniq = checkString(line);

        if(!ifStrUniq) {
            nodes.get(0).recPreOrder();
            int length = 0;
            Set<Character> nodeSet = Node.result.keySet();

            for (Character c : nodeSet) {
                length = length + (Node.result.get(c).length() * count.get(c));
            }
            System.out.println("Number of unique chars: " + Node.result.keySet().size() + " Length of output binary code: " + length);

            for (Character c : nodeSet) {
                System.out.println(c + ": " + Node.result.get(c));
            }
            String result = "";
            for (char c : line.toCharArray()) {
                result = result + Node.result.get(c);
            }
            System.out.println("Output binary code: " + result);
        } else {
            int length = line.length();
            System.out.println("Number of unique chars: 1" + " Length of output binary code:  " + length);
            System.out.println(line.charAt(0) + ": " + 0);
            String result = "";
            for(int i = 0 ; i < length; i ++){

                result = result + "0";
            }
            System.out.println("Output binary code: " + result);
        }


    }

    private static boolean checkString(String s){
        boolean res = true;
        char c = s.charAt(0);
        for(int i = 0 ; i < s.length();i++){
            if(s.charAt(i) != c)
                res = false;
        }
        return res;
    }
}


