// https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode p=head;
        ListNode curr=head;
        ListNode q=null;
        int count=0;
        while(p!=null && count<k){
            p=p.next;
            curr.next=q;
            q=curr;
            curr=p;
            count++;
        }
        if(count==k){
            head.next= reverseKGroup(p,k);
        }
        if(count<k && count>0){
            return reverseKGroup(q,count);
        }
        return q;
    }
}