/*
Insertion Sort
create a dummy head easy to insert node at the front
loop through each node (curr)
find the node (prev) before curr’s insertion position
insert curr into the correct position
go to next node
*/

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while(curr != null) {
            ListNode prev = dummy;
            ListNode nextNode = curr.next;

            while(prev.next!=null && prev.next.val<curr.val) {
                prev = prev.next;    //find the node prev before curr's insertion position
            }

            curr.next = prev.next;
            prev.next = curr;
            curr = nextNode;
        }

        return dummy.next;
    }
}