// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
         ListNode ref = head; 
    
    for(int i=0;i<k-1;i++)
        ref=ref.next;
    
    ListNode kthnode = ref;
    
    ListNode kthlast = head;
    while(ref.next!=null)
    {
        ref=ref.next;
        kthlast = kthlast.next;
    }
    
    System.out.println(kthnode.val +" "+kthlast.val);
    int temp = kthnode.val;
    kthnode.val = kthlast.val;
    kthlast.val = temp;
    
    System.out.println(kthnode.val +" "+kthlast.val);
    return head;
    
}

    
}