package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * @return
     */
    public Node<T> swapPairs() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node<T> temp = head;
        while (temp != null && temp.next != null) {
            T tempVal = temp.data;
            temp.data = temp.next.data;
            temp.next.data = tempVal;
            temp = temp.next.next;
        }
        return head;
    }

    /**
     * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
     * instead you will be given access to the node to be deleted directly.
     * It is guaranteed that the node to be deleted is not a tail node in the list.
     *
     * @param node
     */
    public void deleteNode(Node<T> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    /**
     * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
     * talking about the node number and not the value in the nodes.
     * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
     *
     * @return
     */
    public Node<T> oddEvenList() {
        if (head == null) {
            return null;
        }
        Node<T> front = head.next;
        Node<T> evenHead = head.next;
        Node<T> back = head;
        while (front != null && front.next != null) {
            back.next = front.next;
            back = back.next;
            front.next = back.next;
            front = front.next;
        }
        back.next = evenHead;
        return head;
    }

    /**
     * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive
     * linked list "parts".
     * <p>
     * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
     * This may lead to some parts being null.
     * <p>
     * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a
     * size greater than or equal parts occurring later.
     * <p>
     * Return a List of ListNode's representing the linked list parts that are formed.
     * <p>
     * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
     *
     * @param k
     * @return
     */
    public Node<T>[] splitListToParts(int k) {
        int n = sizeOfList();
        int noOfElementsInEachSplit = n / k;
        int spillOver = n % k;
        int[] splits = new int[k];

        //Identify number of elements to be in each split
        for (int i = 0; i < k; i++) {
            if (i < spillOver) {
                splits[i] = noOfElementsInEachSplit + 1;
            } else {
                splits[i] = noOfElementsInEachSplit;
            }
        }

        Node<T> newHead = head;
        Node<T>[] nodes = new Node[k];
        Node<T> temp = head;
        int splitIterator = 0;
        while (temp != null && splitIterator < splits.length) {
            nodes[splitIterator] = temp;
            for (int i = 0; i < splits[splitIterator] - 1; i++) {
                temp = temp.next;
            }
            newHead = temp.next;
            temp.next = null;
            temp = newHead;
            splitIterator++;
        }
        return nodes;
    }

    private int sizeOfList() {
        int size = 0;
        Node<T> temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    /**
     * Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value
     * insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any
     * single node in the list, and may not be necessarily the smallest value in the circular list.
     *
     * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the
     * insertion, the circular list should remain sorted.
     *
     * If the list is empty (i.e., given node is null), you should create a new single circular list and return the
     * reference to that single node. Otherwise, you should return the original given node.
     *
     * Input: head = [3,4,1], insertVal = 2
     * Output: [3,4,1,2]
     *
     * @param insertVal
     * @return
     */
    public Node<T> insert(T insertVal) {
        //find the smallest node in the circular list
        Node<T> temp = head.next;
        Node<T> minNode = head;
        while (temp != head) {
            if (temp.data.compareTo(minNode.data) < 0) {
                minNode = temp;
            }
            temp = temp.next;
        }
        insertInSortedCircular(insertVal, minNode);
        return head;
    }

    private void insertInSortedCircular(T val, Node<T> head) {
        Node<T> prev = head;
        Node<T> temp = head.next;
        boolean smallest = val.compareTo(head.data) < 0;
        while (temp != head) {
            if (val.compareTo(temp.data) < 0 && !smallest) {
                break;
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        Node<T> newNode = new Node(val);
        newNode.next = temp;
        prev.next = newNode;
    }

    public void printList() {
        Node<T> temp = head;
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
        Node<T> temp = head;
        while (temp != null) {
            result.add(temp.data.toString());
            temp = temp.next;
        }
        return String.join(" -> ", result);
    }

    public void printCycleList() {
        Node<T> temp = head.next;
        System.out.println();
        System.out.print(head.data + " -> ");
        while (temp != head) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

