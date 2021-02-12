package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LinkedListTest {

    private Node<Integer> head;

    @Test
    void swapPairs() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateSwapPairsList());
        linkedList.printList();
        linkedList.swapPairs();
        linkedList.printList();
        Assertions.assertEquals("2 -> 1 -> 4 -> 3", linkedList.getStringRepresentation());
    }

    private Node<Integer> generateSwapPairsList() {
        head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        return head;
    }

    @Test
    void deleteNodeTest() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateDeleteNodeList());
        Node<Integer> node = head.next;
        linkedList.printList();
        linkedList.deleteNode(node);
        linkedList.printList();
        Assertions.assertEquals("4 -> 1 -> 9", linkedList.getStringRepresentation());
    }

    private Node<Integer> generateDeleteNodeList() {
        head = new Node<>(4);
        head.next = new Node<>(5);
        head.next.next = new Node<>(1);
        head.next.next.next = new Node<>(9);
        return head;
    }

    @Test
    void oddEvenListTest() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateOddEvenList());
        linkedList.printList();
        linkedList.oddEvenList();
        linkedList.printList();
        Assertions.assertEquals("1 -> 3 -> 5 -> 2 -> 4", linkedList.getStringRepresentation());
    }

    private Node<Integer> generateOddEvenList() {
        head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        return head;
    }

    @Test
    void splitListToPartsTest1() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateSplitListToPartsList1());
        linkedList.printList();
        Node<Integer>[] result = linkedList.splitListToParts(5);
        List<String> resultString = Arrays.asList(result).stream()
                .map(i -> {
                    if (i == null) {
                        return "NULL";
                    }
                    StringBuilder response = new StringBuilder();
                    response.append("[");
                    response.append(String.join(" -> ", new LinkedList(i).getStringRepresentation()));
                    response.append("]");
                    return response.toString();
                })
                .collect(Collectors.toList());
        String output = "[" + String.join(",", resultString) + "]";
        System.out.println(output);
        Assertions.assertEquals("[[1],[2],[3],[4],NULL]",output);
    }

    @Test
    void splitListToPartsTest2() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateSplitListToPartsList2());
        linkedList.printList();
        Node<Integer>[] result = linkedList.splitListToParts(3);
        List<String> resultString = Arrays.asList(result).stream()
                .map(i -> {
                    if (i == null) {
                        return "NULL";
                    }
                    StringBuilder response = new StringBuilder();
                    response.append("[");
                    response.append(String.join(" -> ", new LinkedList(i).getStringRepresentation()));
                    response.append("]");
                    return response.toString();
                })
                .collect(Collectors.toList());
        String output = "[" + String.join(",", resultString) + "]";
        System.out.println(output);
        Assertions.assertEquals("[[1 -> 2 -> 3 -> 4],[5 -> 6 -> 7],[8 -> 9 -> 10]]", output);
    }

    private Node<Integer> generateSplitListToPartsList1() {
        head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        return head;
    }

    private Node<Integer> generateSplitListToPartsList2() {
        head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = new Node<>(6);
        head.next.next.next.next.next.next = new Node<>(7);
        head.next.next.next.next.next.next.next = new Node<>(8);
        head.next.next.next.next.next.next.next.next = new Node<>(9);
        head.next.next.next.next.next.next.next.next.next = new Node<>(10);
        return head;
    }

    @Test
    void insertTest() {
        LinkedList<Integer> linkedList = new LinkedList<>(generateInsertList());
        linkedList.printCycleList();
        linkedList.insert(2);
        linkedList.printCycleList();
    }

    private Node<Integer> generateInsertList() {
        head = new Node<>(3);
        head.next = new Node<>(4);
        head.next.next = new Node<>(1);
        head.next.next.next = head;
        return head;
    }
}