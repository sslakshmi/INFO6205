package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void addToTail() {
        DoublyLinkedList doubleLinkedList = new DoublyLinkedList(initList());
        doubleLinkedList.printList();
        doubleLinkedList.addToTail(5);
        doubleLinkedList.printList();
        Assertions.assertEquals("1 <-> 2 <-> 3 <-> 4 <-> 5", doubleLinkedList.getStringRepresentation());
    }

    @Test
    void addToHeadTest() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(initList());
        doublyLinkedList.printList();
        doublyLinkedList.addToHead();
        doublyLinkedList.printList();
        Assertions.assertEquals("5 <-> 1 <-> 2 <-> 3 <-> 4", doublyLinkedList.getStringRepresentation());
    }

    @Test
    void sizeTest() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(initList());
        doublyLinkedList.printList();
        System.out.println(doublyLinkedList.size());
        Assertions.assertEquals(4, doublyLinkedList.size());
    }

    private DoubleNode initList() {
        DoubleNode head;
        DoubleNode one = new DoubleNode(1);
        DoubleNode two = new DoubleNode(2);
        DoubleNode three = new DoubleNode(3);
        DoubleNode four = new DoubleNode(4);

        head = one;
        one.next = two;
        two.prev = one;

        two.next = three;
        three.prev = two;

        three.next = four;
        four.prev = three;

        return head;
    }


}