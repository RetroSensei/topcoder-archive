package com.topcoder.archive;

/**
 * RetroSensei
 * https://community.topcoder.com/stat?c=problem_statement&pm=14428
 */

public class SquareFreeString {

    public static void main(String[] args) {
        System.out.println(isSquareFree("beriberi"));
        System.out.println(isSquareFree("bobo"));
        System.out.println(isSquareFree("apple"));
        System.out.println(isSquareFree("qwertyuiopasdfghjklzxcvbnm"));
        System.out.println(isSquareFree("aydyamrbnauhftmphyrooyq"));
    }

    public static String isSquareFree(String s) {
        int startIndex = 0;
        while(startIndex < s.length()-1) {
            for (int i = startIndex + 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(startIndex)) {
                    int counter = 0;
                    for (int j = startIndex; j < i + (i - startIndex); j++) {
                        if (!(s.charAt(j) == s.charAt(i + counter))) {
                            break;
                        }
                        if (counter == i - startIndex - 1) {
                            return "not square-free";
                        }
                        counter++;
                    }
                }
            }
            startIndex++;
        }
        return "square-free";
    }
}