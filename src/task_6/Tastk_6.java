package task_6;

public class Tastk_6 {

	public static void main(String[] args) {
		/*
		 * The sum of the squares of the first ten natural numbers is,
		 * 
		 * 1^2 + 2^2 + ... + 10^2 = 385 The square of the sum of the first ten natural
		 * numbers is,
		 * 
		 * (1 + 2 + ... + 10)^2 = 55^2 = 3025 Hence the difference between the sum of
		 * the squares of the first ten natural numbers and the square of the sum is
		 * 3025 − 385 = 2640.
		 * 
		 * Find the difference between the sum of the squares of the first one hundred
		 * natural numbers and the square of the sum.
		 */
		int limit = 100;
		int sumOfSquare = getSumOfSquare(limit);
		int squareOfSum = getSquareOfSum(limit);

		System.out.println(squareOfSum - sumOfSquare);
	}

	private static int getSumOfSquare(int limit) {
		int sum = 0;
		for (int i = 0; i < limit; i++) {
			sum += Math.pow(i, 2);
		}
		return sum;
	}

	// using SUM(n) = n*(n+1) / 2
	private static int getSquareOfSum(int limit) {
		int sum = (limit * (limit + 1)) / 2;
		return (int) Math.pow(sum, 2);
	}

}
