package edu.northeastern;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Question5 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //Final reversed head that needs to be returned
        ListNode newHead = null;
        ListNode temp = head;
        ListNode kTail = null;

        while(temp != null){
            int count = 0;
            temp = head;
            while(count < k && temp != null){
                //traverse k nodes, to see if there are k nodes available to be reversed
                temp = temp.next;
                count++;
            }
            if(count == k){
                //now we reverse, and get the new head
                ListNode revHead = reverse(head, k);

                if(newHead == null){
                    newHead = revHead;
                }

                if(kTail != null){
                    kTail.next = revHead;
                }

                kTail = head;
                head = temp;
            }
        }

        if(kTail != null){
            kTail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    public ListNode reverse(ListNode head, int k) {
        // This function assumes that the list contains 
        // atleast k nodes.
        ListNode newHead = null;
        ListNode mid = head;

        while (k > 0) {
            ListNode front = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = front;
            k--;
        }
        return newHead;

    }

    public void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode revHead = question5.reverseKGroup(head, 2);
        question5.printList(revHead);
    }
}
