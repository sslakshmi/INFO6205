package edu.northeastern;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Question2 question2 = new Question2();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(question2.canFinish(numCourses, prerequisites));

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(question2.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDependency = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int dependency = prerequisites[i][1];
            List<Integer> courses = courseDependency.getOrDefault(dependency, new ArrayList<>());
            courses.add(course);
            courseDependency.put(dependency, courses);
            inDegree[course] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            List<Integer> adjacentNodes = courseDependency.getOrDefault(node, new LinkedList<>());
            for (Integer item : adjacentNodes) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    queue.add(item);
                }
            }
            i += 1;
        }
        return i == numCourses;
    }
}
