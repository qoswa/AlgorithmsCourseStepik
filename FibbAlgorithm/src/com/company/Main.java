package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long d = in.nextLong();
        BigInteger result = calcFib(n,d);

        System.out.println(result);
    }

    private static BigInteger calcFib(long n,long d) {

        if(n<=1){
            return BigInteger.valueOf(n);
        }

        BigInteger last = BigInteger.ONE;
        BigInteger beforeLast = BigInteger.ZERO;
        BigInteger temp;
        for(int i = 2 ; i <= n ;i ++){
            temp = last;
            last = last.add(beforeLast).mod(BigInteger.valueOf(d));
            beforeLast = temp;
        }
        return last.mod(BigInteger.valueOf(d));
    }
}