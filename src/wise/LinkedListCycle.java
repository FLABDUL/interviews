package wise;

import java.util.HashSet;

public class LinkedListCycle {
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
        LinkedListCycle LinkedListCycle = new LinkedListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(-4);

        // Print the original list (optional)
        System.out.print("Original List: ");
        printList(head);

        // Reverse the list
        boolean hasCylce = hasCycleTwoPointer(head);

        // Print the reversed list
        System.out.print("has cycle: " + hasCylce);
    }

    public static boolean hasCycleTwoPointer(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode walker = head;//1 step
        ListNode runner = head;//2 step
        while(runner.next!= null && runner.next.next!=null){//check can 2 steps
            walker = walker.next;//step forward once
            runner = runner.next.next;
            if(walker==runner){//loop check
                return true;
            }
        }
        return false;
        /*
        floyds tortoise and hard algorithm e.g. fast/slow pointer
        time On visit each node once n
        space O1 no extra data structures, references only
        handles no nod eedge case, efficeint long list

         */
    }

    public static boolean hasCycleHashTable(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode currentNode = head;
        while(currentNode != null){
            if(visitedNodes.contains(currentNode)){//there is loop!
                return true;
            }
            visitedNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
        /*
        pro doesnt require knowledge linked list
        space On hashset store all nodes
        not efficient large lists
        O1 add/contains + overhead due to hashset
        time On add/contains each node O1, n number nodes DUE TO COLLISIONS
         */
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
