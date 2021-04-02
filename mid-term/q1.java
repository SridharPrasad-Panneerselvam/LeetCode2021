//Write a function to determine whether two singly-linked lists are converging.

// Time Complexity - O(n^2)
// Space Complexity - O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){
    this.val = val;
    }
    ListNode(int val, ListNode next){ 
    this.val = val; 
    this.next = next;
    }
}
    
class Solution {
    public static boolean areConverging(ListNode n1, ListNode n2){
    while (n1 != null) {
            ListNode Node2 = n2;
            while (Node2 != null) { 
                if(n1 == Node2)
                {
                    return true;
                }
                Node2 = Node2.next;
            }
            n1 = n1.next;
        }
        return false;
    
    }
    
      public static void main(String[] args){
      
         //converging test case
        ListNode converging = new ListNode(-3, new ListNode(-4));
        ListNode nodeA = new ListNode(3, new ListNode(4, converging));
        ListNode nodeB = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8,converging))));
   
        //non-converging test case
        ListNode nonconverging = new ListNode(-3, new ListNode(-4));
        ListNode nodeC = new ListNode(3, new ListNode(4, nonconverging));
        ListNode nodeD = new ListNode(5, new ListNode(6, new ListNode(7)));

   
        System.out.println(areConverging(nodeA, nodeB));
        System.out.println(areConverging(nodeC, nodeD));
      }
}