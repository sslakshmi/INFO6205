package edu.northeastern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();

        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        question3.setZeroes(matrix);
        System.out.print("[ ");
        for (int[] ints : matrix) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.print("]");
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                isCol = true;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol == true) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroesUsingSet(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rSet.add(i);
                    cSet.add(j);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rSet.contains(i) || cSet.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
