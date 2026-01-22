//Problem

    /*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    
     
    
    Example 1:
    
    
    Input: head = [1,2,2,1]
    Output: true
    Example 2:
    
    
    Input: head = [1,2]
    Output: false
     
    
    Constraints:
    
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
     
    
    Follow up: Could you do it in O(n) time and O(1) space?*/

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid=mid(head);
        ListNode secondHalf=reverse(mid.next);
        ListNode firstHalf=head;

        while(secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }

    public static ListNode mid(ListNode head){
        ListNode slow =head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode mid){
        if(mid==null || mid.next==null){
            return mid;
        }
        ListNode newHead=reverse(mid.next);
        mid.next.next=mid;
        mid.next=null;
        return newHead;
    }
}
