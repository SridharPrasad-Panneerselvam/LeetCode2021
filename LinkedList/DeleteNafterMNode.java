// https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/


public ListNode deleteNodes(ListNode head, int m, int n) {

    ListNode dummy = new ListNode();
    dummy.next = head;
    if(head == null){
        return head;
    }
    ListNode cur = dummy;
    while(cur != null){
        int keep = m;
        while(cur != null && keep > 0){
            cur = cur.next;
            keep --;
        }
        ListNode cur1 = cur;
        int delete = n;
        while(cur1 != null && delete > 0){
            cur1 = cur1.next;
            delete--;
        }
        if(cur1 != null){
            cur.next = cur1.next;
        } else{
            if(cur != null){
                cur.next = null;
                break;
            }
        }   
    }
    return dummy.next;
}