package edu.northeastern;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question4 {

    /**
     * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
     *
     * If possible, output any possible result.  If not possible, return the empty string.
     *
     * Example 1:
     * Input: S = "aab"
     * Output: "aba"
     *
     * Example 2:
     * Input: S = "aaab"
     * Output: ""
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        char[] output = new char[s.length()];
        HashMap<Character,Integer> charCount = new HashMap<>();
        for(char c : s.toCharArray()){
            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            }
            else{
                charCount.put(c,1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedCharCount = charCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());

        int j = 1;
        for(Map.Entry<Character,Integer> entry: sortedCharCount){
            char c = entry.getKey();
            int count = entry.getValue();
            if(count > (s.length() + 1)/2){
                return "";
            }
            for(int i = 0; i< count; i++){
                if(j >= s.length()){
                    j = 0;
                }
                output[j] = c;
                j += 2;
            }
        }
        return new String(output);
    }

}
