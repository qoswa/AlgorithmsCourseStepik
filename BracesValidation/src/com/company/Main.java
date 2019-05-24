package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String string = in.next();
        System.out.println(checkString(string));
    }


    private static String checkString(String str){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indStack = new Stack<>();

        for(int i = 0 ; i < str.length();i++ ){
            char c = str.charAt(i);
            if(c == '(' ) {
                stack.push(0);
                indStack.push(i);
            }
            else if (c == '[') {
                stack.push(1);
                indStack.push(i);
            }
            else if (c == '{'){
                stack.push(2);
                indStack.push(i);
            }
            else if (c == ')' || c ==']' || c =='}'){
                if(stack.isEmpty()) {
                    i++;
                    return i+"";
                }
                int top = stack.pop();
                indStack.pop();

                if((top == 0 && c !=')' )|| (top == 1 && c != ']') || ((top==2)&& c!= '}')){

                    return (i+1) + "";
                }


            }
        }
        if(stack.isEmpty()){
            return "Success";
        } else {
            int q = -1;
            while(!indStack.isEmpty()){
                q = indStack.pop();
            }
            return (q+1) + "";
        }
    }
}