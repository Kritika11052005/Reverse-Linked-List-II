public class LeetCode {
    
 // Definition for singly-linked list.
public class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {//Function reverseBetween with Head of the LinkedList and the left and right positions of the integer. 
        ListNode dummy = new ListNode(0);//Creating a dummy node
        dummy.next=head;//dummy node is placed before head
        ListNode dummy_pointer=dummy;//Another Node named dummy_pointer is created which points at dummy node.
        ListNode temp=head;//temp points at head node
        //this for-loop shifts the the temp to point to node from where the reverse process starts and dummy_pointer is shifted previous to the temp pointer.
        for(int i=0;i<left-1;i++){
            dummy_pointer=dummy_pointer.next;
            temp=temp.next;
        }
        
        ListNode CurrNode=temp;//another node is created to point to temp pointer known as the CurrentNode.
        ListNode PrevNode=null;//another node is created which points to null;
        // this for-loop iterates through the sub-LinkedList in order to reverse it.
        for(int i=0;i<right-left+1;i++){
            ListNode NextNode=CurrNode.next; //Another node NextNode is created to point to the node after CurrentNode.
            CurrNode.next=PrevNode;//the current node will point towards the previous node(in the first iteration it will point towards null)
            PrevNode =CurrNode;//then the previous node is updated to the current node
            CurrNode=NextNode;//then the next node is updated to the current node.
        }
        //then these final pieces are joined together
        dummy_pointer.next=PrevNode;//the node where the reverse process ends will be the next node to the node which was previous to node from where the reverse process startred.
        temp.next=CurrNode;//the node from where the reverse process was started will be joined with the node next to the node where the reverse process ended.

        return dummy.next;//returns the LinkedList.
        
    }
}
}
