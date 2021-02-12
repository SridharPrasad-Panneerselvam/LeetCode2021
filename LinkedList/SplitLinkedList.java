// https://leetcode.com/problems/split-linked-list-in-parts/


class Solution {
    public int getSize(ListNode root) {
        int cnt = 0;
        while(root != null) {
            root = root.next;
            cnt++;
        }
        return cnt;
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = getSize(root);
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<k;i++) {
            map.put(i,0);
        }
        int temp = 0;
        for(int i=0;i<size;i+=k) {
            for(int j=0;j<k;j++) {
                if(temp<size) {
                    map.put(j,map.get(j)+1);
                }
                
                temp++;
            }
        }
        
        
        ListNode[] result = new ListNode[k];
        for(int i=0;i<k;i++) {
            ListNode node = new ListNode(0);
            ListNode tempNode = node;
            for(int j=0;j<map.get(i);j++) {
                node.next = new ListNode(root.val);
                root = root.next;
                node = node.next;
            }
            result[i] = tempNode.next;
        }
        
        return result;
    }
}