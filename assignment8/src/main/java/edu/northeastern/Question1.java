package edu.northeastern;

import java.util.*;

public class Question1 {
    // Since the type of the graph is not specified, the graph is assumed to be a non-weighted non-directed graph
    public static void main(String[] args) {
        // Adjacency list for a non-directed graph
        List<Integer> zero = Arrays.asList(1, 7);
        List<Integer> one = Arrays.asList(0, 2, 7);
        List<Integer> two = Arrays.asList(5, 3, 8, 1);
        List<Integer> three = Arrays.asList(2, 4, 5);
        List<Integer> four = Arrays.asList(3, 5);
        List<Integer> five = Arrays.asList(4, 3, 2, 6);
        List<Integer> six = Arrays.asList(5, 8, 7);
        List<Integer> seven = Arrays.asList(0, 1, 8, 6);
        List<Integer> eight = Arrays.asList(2, 6, 7);
        List<List<Integer>> graph = Arrays.asList(zero, one, two, three, four, five, six, seven, eight);
        Integer source = 4;
        Integer[] shortestPaths = shortestPath(graph, source);
        System.out.println(String.format("Shortest path starting from node %s", source));
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println(String.format("Shortest path to node %s is %s", i, shortestPaths[i]));
        }
    }

    public static Integer[] shortestPath(List<List<Integer>> graph, Integer source) {
        int size = graph.size();
        Integer[] output = new Integer[size];
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.add(graph.get(source));
        Integer distance = 1;
        output[source] = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> currentLevel = new ArrayList<>();
            List<Integer> nodes = queue.poll();
            for (Integer node : nodes) {
                if (output[node] == null || output[node] > distance) {
                    output[node] = distance;
                }
                currentLevel.addAll(graph.get(node));
            }
            queue.add(currentLevel);
            distance += 1;
        }
        return output;
    }
}
