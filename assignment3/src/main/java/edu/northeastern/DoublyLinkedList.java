package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {

    DoubleNode head;

    public DoublyLinkedList(DoubleNode head) {
        this.head = head;
    }

    public void addToTail(int data) {
        DoubleNode node = new DoubleNode(data);
        if (head == null) {
            head = node;
            return;
        }
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void printList() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addToHead() {
        DoubleNode node = new DoubleNode(5);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public int size() {
        int count = 0;
        DoubleNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public String getStringRepresentation() {
        List<String> result = new ArrayList<>();
        DoubleNode temp = head;
        while (temp != null) {
            result.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        return String.join(" <-> ", result);
    }
}
