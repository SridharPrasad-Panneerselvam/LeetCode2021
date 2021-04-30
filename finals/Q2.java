//TheFibonacci numbers, commonly denotedF(n)form a sequence, called theFibonacci sequence, 
//such that each number is the sum of the two preceding ones, starting from0and1

// Time Complexity - O(n)
// Space Complexity - O(1)


public class Solution {
    public int fib(int n)
	{
		int a = 0, b = 1, c;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main (String args[])
	{
		int n = 9;
		Solution sl = new Solution();
		System.out.println(sl.fib(n));
	}
}