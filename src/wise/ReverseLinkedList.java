package wise;
//https://www.youtube.com/watch?v=G0_I-ZF0S38
public class ReverseLinkedList {
    public static class ListNode {
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

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list (optional)
        System.out.print("Original List: ");

        printList(head);

        // Reverse the list
        ListNode reversedHead = reverseLinkedList.reverseListIterative(head);

        // Print the reversed list
        System.out.print("Reversed List: ");
        printList(reversedHead);
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode prevHead = null;
//        while (head != null) {
//            ListNode recordNext = head.next;
//            head.next = prevHead;
//            prevHead = head;
//            head = recordNext;
//        }
//        return prevHead;
//    }

    public ListNode reverseListIterative(ListNode head) {//makes more sense
        ListNode prev = null;
        ListNode current = head;


        while(current != null) {
            ListNode next = current.next;//save break link to next
            current.next = prev;//point backwards
            prev = current;//previous is now here where we are
            current = next;//current is the back which was saved
        }
        return prev;//previous is new HEAD
    }//good explanation https://leetcode.com/problems/reverse-linked-list/solutions/2682085/java-0ms-100-easy-understanding/

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /*
    On time constant work for length n
    O1 space constant, no additioanl data structures
    iterative no overhead
    cons modifieds original list

     */

    public ListNode reverseListRecursive(ListNode head) {
        // Base case: If head is null or there's only one element, the list is already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive step: Reverse the rest of the list
        ListNode reversedListHead = reverseListRecursive(head.next);
        //POINTED HEAD TO LAST NODE


        // After reversing the rest of the list, we update the next of the current head node to point to itself
        head.next.next = head;  // Make the next node point back to the current node
        //EFFECTIVELY REVERSES LIST

        // Set the current node's next to null because it will become the last node of the reversed list
        head.next = null;
        //CURRENT NODE IS NOW LAST NODE

        // Return the head of the reversed list
        return reversedListHead;
    }
    /*
    time On visited once linear
    space On worst case n nodes due to call stack
    functional programming, breaking down problem to subproblems
    linked lists naturally recursive
    cons stack overflow large lists
    hard to debug
     */
}
