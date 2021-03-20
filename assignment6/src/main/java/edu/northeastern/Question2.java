package edu.northeastern;

import java.util.Arrays;
import java.util.Stack;

/**
 *We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */
public class Question2 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            collision: {
                while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                    if(stack.peek() < -asteroid){
                        //peek asteroid is destroyed by incoming -ve asteroid which is much bigger.
                        // This needs to be checked against other +ve asteroids in its way
                        stack.pop();
                        continue;
                    }
                    else if(stack.peek() == -asteroid){
                        //peek asteroid is destroyed by incoming -ve asteroid which is of same size
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(asteroid);
            }
        }
        int[] ast = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            ast[i] = stack.pop();
        }
        return ast;
    }

    public static void main(String[] args) {
        int[] asteroids = new int[]{5, 10, -5};
        Question2 question2 = new Question2();
        int[] output = question2.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(output));
    }
}
