package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    /**
     * You are given two linked lists: list1 and list2 of sizes n and m respectively.
     * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
     * <p>
     * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * Output: [0,1,2,1000000,1000001,1000002,5]
     * <p>
     * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
     * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     */
    public Node mergeInBetween(Node list1, int a, int b, Node list2) {
        Node temp_list1 = list1;
        Node temp_list2 = list2;
        Node nodeA = null; //2
        Node nodeB = null; //5
        //a th node
        for (int i = 0; i < a; i++) {
            nodeA = temp_list1;
            temp_list1 = temp_list1.next;
        }

        //b th node
        for (int i = 0; i <= b - a; i++) {
            nodeB = temp_list1;
            temp_list1 = temp_list1.next;
        }
        // end of list2
        //temp_list2 = 1000002
        while (temp_list2.next != null) {
            temp_list2 = temp_list2.next;
        }

        nodeA.next = list2;
        temp_list2.next = nodeB.next;
        head = list1;
        return list1;
    }

    /**
     * You are given the head of a linked list, and an integer k.
     * Return the head of the linked list after swapping the dataues of the kth node from the beginning and the kth node
     * from the end (the list is 1-indexed).
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     * <p>
     * Input: head = [1], k = 1
     * Output: [1]
     * <p>
     * Input: head = [1,2], k = 1
     * Output: [2,1]
     * <p>
     * Input: head = [1,2,3], k = 2
     * Output: [1,2,3]
     *
     * @param k
     * @return
     */
    public void swapNodes(int k) {
        Node back = head;
        Node front = head.next;
        int temp;
        Node node1 = head;

        if (head == null) {
            return;
        }

        if (head.next == null) {
            return;
        }

        for (int i = 0; i < k - 1; i++) {
            if (front != null) {
                front = front.next;
                node1 = node1.next;
            } else {
                return;
            }
        }
        while (front != null) {
            back = back.next;
            front = front.next;
        }

        temp = node1.data;
        node1.data = back.data;
        back.data = temp;
    }

    /**
     * Remove all elements from a linked list of integers that have dataue data.
     *
     * @param data
     */
    public void removeElements(int data) {
        if (head == null) {
            return;
        }
        // [1,1]
        while (head.data == data) {
            head = head.next;
            if (head == null) {
                return;
            }
        }
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data == data) {
                prev.next = temp.next;
            } else {
                prev = prev.next;
            }
            temp = temp.next;
        }
    }

    /**
     * Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the
     * following way:
     * <p>
     * Start with the head as the current node.
     * Keep the first m nodes starting with the current node.
     * Remove the next n nodes
     * Keep repeating steps 2 and 3 until you reach the end of the list.
     * Return the head of the modified list after removing the mentioned nodes.
     *
     * @param m
     * @param n
     */
    public void deleteNodes(int m, int n) {
        int shiftCount = 1;
        Node curr = null;
        Node temp = head;

        while (temp != null) {
            if (shiftCount == m) {
                shiftCount = 1;
                curr = temp;
                for (int i = 0; i < n; i++) {
                    if (curr.next != null) {
                        curr = curr.next;
                    } else {
                        break;
                    }
                }
                temp.next = curr.next;
                temp = temp.next;
            } else {
                shiftCount++;
                temp = temp.next;
            }
        }
    }

    public void printList() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    /**
     * return a string representation of the linked list
     */
    public String getStringRepresentation() {
        List<String> result = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            result.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        return String.join(" -> ", result);
    }
}
