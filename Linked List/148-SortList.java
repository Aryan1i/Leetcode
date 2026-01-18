//Problem

    /*Given the head of a linked list, return the list after sorting it in ascending order.
    
     
    
    Example 1:
    
    
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]
    Example 2:
    
    
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]
    Example 3:
    
    Input: head = []
    Output: []
     
    
    Constraints:
    
    The number of nodes in the list is in the range [0, 5 * 104].
    -105 <= Node.val <= 105
     
    
    Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?*/

//Solution

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode mid=mid(head);
        ListNode nextt=mid.next;
        mid.next=null;
        

        ListNode fh=sortList(head);
        ListNode sh=sortList(nextt);
        ListNode sort = mergeSortedList(fh,sh);
        return sort;
    }

    public static ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static ListNode mergeSortedList(ListNode f,ListNode s){
        ListNode list = new ListNode();
        ListNode dummy = list;

        while(f!=null && s!=null){
            ListNode temp = new ListNode();
            if(f.val<s.val){
                temp.val=f.val;
                f=f.next;
            }else{
                temp.val=s.val;
                s=s.next;
            }
            list.next=temp;
            list=list.next;
        }

        while(f!=null){
            ListNode temp = new ListNode();
            temp.val=f.val;
            f=f.next;
            list.next=temp;
            list=list.next;
        }

        while(s!=null){
            ListNode temp = new ListNode();
            temp.val=s.val;
            s=s.next;
            list.next=temp;
            list=list.next;
        }
        return dummy.next;
    }
}
