package com.artemnizhnyk.somepurejavapractice.three;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringPractice {
    private static int findPermutationDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int permutationDifference = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                int counter = t.indexOf(sArray[i]) - i;
                if (counter > 0) permutationDifference += counter;
                else permutationDifference -= counter;
            }
        }
        return permutationDifference;
    }

    public static int mostWordsFound(String[] sentences) {
        return Integer.parseInt(Arrays.stream(sentences).reduce("0", (accumulator, sentence) -> {
            int length = sentence.split(" ").length;
            if (length > Integer.parseInt(accumulator)) {
                accumulator = String.valueOf(length);
            }
            return accumulator;
        }));
    }

    public static void main(String[] args) {
        System.out.println(findPermutationDifference("abc", "bac"));
        System.out.println(mostWordsFound(new String[]{"asdasd asdasd", "asdasdasd", "asdas asdas asdas sadasdas sadasdasd", "asdasd asdasda"}));
    }
}
