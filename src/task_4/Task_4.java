package task_4;

public class Task_4 {

	public static void main(String[] args) {
		/*
		 * A palindromic number reads the same both ways. 
		 * The largest palindrome made from the product of two 2-digit 
		 * numbers is 9009 = 91 × 99.

			Find the largest palindrome made from the product of two 3-digit numbers.
		 * 
		 * O(n^2) where n = max - min;
		 */
		
		int max = 1000;
		int min = 100;
		
		System.out.println(getMaxPolindrom(min,max));
	}
	
	
	public static int getMaxPolindrom(int bottomBound, int upperBound) {
		
		int maxPolindrom = 0;
		
		for(int i = bottomBound; i < upperBound ;i++) {
			for(int j = i; j < upperBound; j++) {		// second loop starts from i, 
																			//because all numbers before were already checked			
				int temp = i*j;
				if (isPolindrom(temp+""))
					if(temp > maxPolindrom)
						maxPolindrom = temp;
			}
		}
		return maxPolindrom;
	}
	
	public static boolean isPolindrom(String num) {
		StringBuilder sb = new StringBuilder(num);
		return num.equals(sb.reverse().toString());
	}

}
