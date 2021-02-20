package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void mergeInBetweenTest1() {
        LinkedList linkedList = new LinkedList(null);
        //linkedList.printList();
        linkedList.mergeInBetween(generateList1(), 3, 4, generateList2());
        linkedList.printList();
        Assertions.assertEquals("0 -> 1 -> 2 -> 1000000 -> 1000001 -> 1000002 -> 5", linkedList.getStringRepresentation());

    }

    private Node generateList2() {
        Node head = new Node(1000000);
        head.next = new Node(1000001);
        head.next.next = new Node(1000002);
        return head;
    }

    private Node generateList1() {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        return head;
    }

    @Test
    void swapNodesTest1() {
        LinkedList linkedList = new LinkedList(generateSwapNodesList());
        linkedList.printList();
        linkedList.swapNodes(2);
        linkedList.printList();
        Assertions.assertEquals("1 -> 4 -> 3 -> 2 -> 5", linkedList.getStringRepresentation());

    }

    private Node generateSwapNodesList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        return head;
    }

    @Test
    void removeElementsTest1() {
        LinkedList linkedList = new LinkedList(generateRemoveElementsList());
        linkedList.printList();
        linkedList.removeElements(6);
        linkedList.printList();
        Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedList.getStringRepresentation());

    }

    private Node generateRemoveElementsList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        return head;
    }

    @Test
    void deleteNodesTest1() {
        LinkedList linkedList = new LinkedList(generateDeleteNodesList());
        linkedList.printList();
        linkedList.deleteNodes(2, 3);
        linkedList.printList();
        Assertions.assertEquals("1 -> 2 -> 6 -> 7 -> 11", linkedList.getStringRepresentation());

    }

    private Node generateDeleteNodesList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next.next.next.next = new Node(11);
        return head;
    }
}