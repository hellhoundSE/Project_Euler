package task_1;

public class Task_1 {

	public static void main(String[] args) {
		
		/*
		 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
		 * we get 3, 5, 6 and 9. The sum of these multiples is 23.

			Find the sum of all the multiples of 3 or 5 below 1000.
		 * 
		 * O(1)
		 */
		
		//sum limit
		// 1000 in not included
		int limit = 1000;

		int divider1 = 3;
		int divider2 = 5;
	
		System.out.println(
				findSumFor(divider1,limit) + 
				findSumFor(divider2,limit) - 
				findSumFor( divider1 * divider2,limit));
	}

	public static int findSumFor(int num,int limit) {
		//finding amount of numbers divisible by num;
		int amt =(limit-1)/num;
		
		//according to SUM(1,n) = (n*(n+1)) /2
		return num * (amt*(amt+1)/2);

	}
}
