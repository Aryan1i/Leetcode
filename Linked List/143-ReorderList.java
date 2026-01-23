//Problem

    /*You are given the head of a singly linked-list. The list can be represented as:
    
    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:
    
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
    
     
    
    Example 1:
    
    
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]
    Example 2:
    
    
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
     
    
    Constraints:
    
    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000*/

//Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = mid(head);
        ListNode reverse=reverse(mid.next);
        mid.next=null;
        while(reverse!=null){
            ListNode t1=head.next;
            ListNode t2=reverse.next;

            head.next=reverse;
            reverse.next=t1;
            
            head=t1;
            reverse=t2;
        }
    }

    public ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode newHead=reverse(head.next);

        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
