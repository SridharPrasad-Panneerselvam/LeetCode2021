// https://leetcode.com/problems/intersection-of-two-arrays/ 

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> m=new HashMap<>();
        List<Integer> ll=new ArrayList<>();
        for(int i: nums1){
            m.put(i, true);
        }
        for(int i: nums2){
            if(m.containsKey(i) && m.get(i)){
                m.put(i, false);
                ll.add(i);
            }
        }
        
        int[] a=new int[ll.size()];
        for(int i=0; i<ll.size() ;i++){
            a[i]=ll.get(i);
        }
        
        return a;
    }
}