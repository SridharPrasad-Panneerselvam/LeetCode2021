// https://leetcode.com/problems/merge-in-between-linked-lists/ 

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        int i = 0;
        while (i+1 != a) {
            head = head.next;
            i++;
        }
        ListNode holder = head;
        while (i != b) {
            head = head.next;
            i++;
        }
        holder.next = list2;
        while (holder.next != null) {
            holder = holder.next;
        }
        holder.next = head.next;
        return list1;
    }
}