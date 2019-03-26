package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String lines = reader.readLine();

        String[] strs = lines.trim().split("\\s+");

        int[] a = new int[2];
        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        int uniqSymb = a[0];
        int codeLength = a[1];

        Map<Character,String> map = new HashMap<>();
        Map<String,Character> revMap = new HashMap<>();
        for(int i = 0 ; i < uniqSymb;i++){
            String line=reader.readLine();

            char c = line.charAt(0);
            String code = line.substring(2);
            map.put(c,code.trim());
            revMap.put(code.trim(),c);
        }

        String result = "";
        String code = reader.readLine();
        int lastIndex = 0;

        for(int i = 0; i <= codeLength;i++){

            String subStr = code.substring(lastIndex,i).trim();
            if(map.containsValue(subStr)){
                result = result + revMap.get(subStr);
                lastIndex = i;
            }
        }

        System.out.println(result);

    }
}
