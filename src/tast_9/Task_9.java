package tast_9;

public class Task_9 {
	
	public static void main(String[] args) {
		/*
		 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
		 * 
		 * a^2 + b^2 = c^2
		 * 
		 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

			There exists exactly one Pythagorean triplet for which a + b + c = 1000.
			Find the product abc.
			
			O(n^2)
		 */
		int sum = 1000;
		int c;
		
		for(int a = 1;a<sum/3 ; a++) {
			for(int b = a+1; b < sum/2 ; b++) { // starts from a+1 because b > a
				c = sum - a - b;
				if(a*a+b*b == c*c) {
					System.out.println(a+" "+b+" "+c);
					System.out.println(a*b*c);
				}
			}
		}
	}
	
}
