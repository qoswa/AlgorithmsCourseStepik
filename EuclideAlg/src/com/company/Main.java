package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int result = GCD(a,b);

        System.out.println(result);
    }

    private static int GCD (int a, int b){

        if(a == 0)
            return b;
        else if (b == 0)
            return a;
        else if (a >= b)
            return GCD(a%b,b);
        else if (b >= a)
            return GCD(a, b % a);
        return -1;
    }
}
