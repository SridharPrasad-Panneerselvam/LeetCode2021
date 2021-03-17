//https://leetcode.com/problems/asteroid-collision/submissions/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            int currVal = Math.abs(curr);
            
            if(curr > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.add(curr);
			} else if(currVal == stack.peek()){ 
				stack.pop();
            } else if(currVal > stack.peek()){
                stack.pop();
                i--; 
            }
                        
        }
        
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}