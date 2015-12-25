//always create dummy node for insertion
//ListNode dummy = new ListNode(-1);
//dummy.next = head;

//return dummy.next

//always record pre, next for deletion
while(pre.next!=null){
	pre = pre.next;


	//after each time we update cur
	cur.next = pre.next; 

	//we need to update pre according to cur 
    pre.next = cur;  
                
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
            //Insertion Sort就是把一个一个元素往已排好序的list中插入的过程。
            //初始时，sorted list是空，把一个元素插入sorted list中。然后，在每一次插入过程中，都是找到最合适位置进行插入。
        
            //因为是链表的插入操作，需要维护pre，cur和next3个指针。
            //each turn pre始终指向sorted list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。
            //because we cannot search from back to front in linkedlist
            
            //当sortedlist为空以及pre.next所指向的元素比cur指向的元素值要大时，需要把cur元素插入到pre.next所指向元素之前。否则，pre指针后移。最后返回fakehead的next即可。
            if(head == null||head.next == null)  {
                return head;
            }
            
            //when we do the linked list insertion
            //first we always want a dummy head so that we return dummy.next in the end
            //and we always want the cur/next/pre and cur=head to be the scanner
            ListNode dummy = new ListNode(-1);
            //dummy.next = head;
            ListNode cur = head;//cur is the scanner
            //whenever there is insertion we need to get pre, cur, and next
            while(cur!=null){
                ListNode pre = dummy;//pre is searching for the pre node for insertion
                //next is for the inserted node's next
                ListNode next = cur.next; 
                //after each time we reset the postion of pre to be fakehead
                //we need to go through the list to find out the right position to find
                while(pre.next!=null && pre.next.val<cur.val){
                    
                    //attention we need to stop right before the right position
                    //so we need to pre.next.val<cur.val instead of pre.val < cur.val
                    pre = pre.next;  
                }  
                //we could insert it into the list
                //link the new node with before and after
                cur.next = pre.next;  
                pre.next = cur;  
                
                
                //the next pointer is used to track the position for next's turn 
                //the starting point is no longer cur.next since cur is inserted to the new position
                //and therefore we need to update cur to be next which is cur's original cur.next
                
                cur=next;//next turn
                
                
            }
            
            return dummy.next;
    
    
    }
}