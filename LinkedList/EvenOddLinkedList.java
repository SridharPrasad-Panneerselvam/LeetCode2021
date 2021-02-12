// https://leetcode.com/problems/odd-even-linked-list/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        int length = 0;
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode end = head;
        ListNode prev = head;
        while(end.next!=null) {
           prev = end;
            end = end.next;
            length++;
        }
        length = length+1;
        
        ListNode endPoint = head.next;
        
        int value = end.val;
        if (length%2 !=0) {
        while(node.val!=value) {
            ListNode temp = new ListNode(node.next.val);
            node.next = node.next.next;
            end.next = temp;
            end = end.next;
            node = node.next;
        }
        }
        if(length%2==0) {
            while(node.next.next!=null && node!=endPoint) {
            ListNode temp = node.next;
            node.next = node.next.next;
            end.next = temp;
            end = end.next;
            end.next = null;
            node = node.next;
        }
        }
        
        return head;
    }
}