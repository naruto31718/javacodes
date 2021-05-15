import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class getNodevalue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode res=llist;
        int index=0;
        while (curr!=null){
            curr=curr.next;
            if (index>positionFromTail){
                res=res.next;
            }
            index++;
        }
        return res.data;
    }
    static boolean hasCycle(SinglyLinkedListNode head) {
         if (head==null){
             return false;
         }
        SinglyLinkedListNode slow=head;
         SinglyLinkedListNode fast=head;
         while (slow!=null&&fast!=null&&fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
             if (slow==fast){
                 return true;
             }
         }
         return false;
    }

    static void reverse(SinglyLinkedListNode head){
        SinglyLinkedListNode prev=null;
        SinglyLinkedListNode current=head;
        SinglyLinkedListNode next = null;
        while(current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current = next;
        }
        //prev will become new head return prev for head
    }

    static void insert_alternate(SinglyLinkedListNode head1,SinglyLinkedListNode head2){
        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2=head2;
        SinglyLinkedListNode next1=null;
        SinglyLinkedListNode next2=null;
        while(curr1!=null&&curr2!=null){
            next1=curr1.next;
            next2=curr2.next;

            curr2.next = next1;
            curr1.next = curr2;

            curr1=next1;
            curr2=next2;
        }

    }

    static class LinkedList{
        Node head;  // head of list

        /* Linked list Node*/
        class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }

        /* Inserts a new Node at front of the list. */
        void push(int new_data)
        {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        // Main function that inserts nodes of linked list q into p at
        // alternate positions. Since head of first list never changes
        // and head of second list/ may change, we need single pointer
        // for first list and double pointer for second list.
        void merge(LinkedList q)
        {
            Node p_curr = head, q_curr = q.head;
            Node p_next, q_next;

            // While there are available positions in p;
            while (p_curr != null && q_curr != null) {

                // Save next pointers
                p_next = p_curr.next;
                q_next = q_curr.next;

                // make q_curr as next of p_curr
                q_curr.next = p_next; // change next pointer of q_curr
                p_curr.next = q_curr; // change next pointer of p_curr

                // update current pointers for next iteration
                p_curr = p_next;
                q_curr = q_next;
            }
            q.head = q_curr;
        }

        /* Function to print linked list */
        void printList()
        {
            Node temp = head;
            while (temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }


    }

    public static void main(String args[])
    {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);

        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);

        System.out.println("Second Linked List:");
        llist2.printList();

        llist1.merge(llist2);

        System.out.println("Modified first linked list:");
        llist1.printList();

        System.out.println("Modified second linked list:");
        llist2.printList();
    }

}
