// https://leetcode.com/problems/reorganize-string/

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charVsCount = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            charVsCount.put(c, charVsCount.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(charVsCount.size(), (a, b) -> b.getValue() - a.getValue());
        
        pq.addAll(charVsCount.entrySet());
        
        Map.Entry<Character,Integer> prev = null;
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            
            Map.Entry<Character,Integer> entry = pq.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            
            if(prev != null) {
                pq.offer(prev);
            }
            
            if(entry.getValue() > 0) {
                prev = entry;
            } else {
                prev = null;
            }
        }
        
        
        return sb.length() == s.length() ? sb.toString() : "";
    }
}