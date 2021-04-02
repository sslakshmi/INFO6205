package northeastern.edu;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Question1 {

    //Time complexity - O(n + m) , n- length of list1 and m- length of list2
    //Space complexity - O(max(m,n)) , 1 of the list values are stored in a set, in worst case number of items is max(m,n)
    public static void main(String[] args) {
        Question1 q1 = new Question1();
        //5 -> 3 -> 4 -> 1 -> null
        //6 ->
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode a = new ListNode(3);
        n1.next = a;
        ListNode b = new ListNode(4);
        a.next = b;
        n2.next = b;
        ListNode c = new ListNode(1);
        b.next = c;
        System.out.println(q1.areConverging(n1, n2)); // true
        //5 -> 3 -> 4 -> 1 -> null
        //6 -> null
        n2.next = null;
        System.out.println(q1.areConverging(n1, n2)); // false

        //5 -> 3 -> 4 -> 1
        //6 ->
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(6);
        ListNode x = new ListNode(3);
        a1.next = x;
        a2.next = x;
        ListNode y = new ListNode(4);
        x.next = y;
        ListNode z = new ListNode(1);
        y.next = z;
        System.out.println(q1.areConverging(a1, a2)); //true

        //5 -> 3 -> 4 -> 1
        ListNode test = new ListNode(5);
        test.next = x;
        System.out.println(q1.areConverging(test, test)); //true

        //null
        //null
        ListNode k1 = null;
        ListNode k2 = null;
        System.out.println(q1.areConverging(k1, k2)); // false
    }

    //Time complexity - O(n)
    public boolean areConverging(ListNode n1, ListNode n2) {
        Set<ListNode> nodes = new HashSet<>();
        while (n1 != null) {
            nodes.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (nodes.contains(n2)) {
                return true;
            }
            n2 = n2.next;
        }
        return false;
    }
}
