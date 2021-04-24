package edu.northeastern;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        System.out
                .println(new Question3().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        //beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
        System.out.println(new Question3().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjacentWordCombinations = new HashMap<>();
        for (String word : wordList) {
            for (String adjacentWord : getPossibleAdjacentWords(word)) {
                List<String> adjacentWords = adjacentWordCombinations.getOrDefault(adjacentWord, new ArrayList<>());
                adjacentWords.add(word);
                adjacentWordCombinations.put(adjacentWord, adjacentWords);
            }
        }

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Arrays.asList(beginWord));
        visited.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            List<String> words = queue.poll();
            List<String> nextLevel = new ArrayList<>();
            for (String word : words) {
                for (String adjacentWildCardWord : getPossibleAdjacentWords(word)) {
                    for (String adjacentWord : adjacentWordCombinations
                            .getOrDefault(adjacentWildCardWord, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return length + 1;
                        }
                        if (!visited.contains(adjacentWord)) {
                            nextLevel.add(adjacentWord);
                            visited.add(adjacentWord);
                        }
                    }
                }
            }
            if (!nextLevel.isEmpty()) {
                queue.add(nextLevel);
            }
            length += 1;
        }

        return 0;
    }

    List<String> getPossibleAdjacentWords(String word) {
        List<String> words = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            words.add(word.substring(0, i) + "_" + word.substring(i + 1));
        }
        return words;
    }
}
