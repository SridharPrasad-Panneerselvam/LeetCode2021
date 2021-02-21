// https://leetcode.com/problems/remove-linked-list-elements/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (true) {
            if (head == null) {
                return head;
            }
            
            if (head.val != val) {
                break;
            }
            
            if (head.val == val) {
                head = head.next;
            }
        }
        ListNode pointer = head;
        
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val == val) {
                if (pointer.next.next != null) {
                    pointer.next = pointer.next.next;
                }
                else {
                    pointer.next = null;
                }
            }
            else {
                pointer = pointer.next;
            }
        }
        
        return head;
    }
}