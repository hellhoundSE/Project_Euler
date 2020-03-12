package task_14;

import java.util.HashMap;
import java.util.Map;

public class Task_14 {

	public static void main(String[] args) {

		/*
		 * The following iterative sequence is defined for the set of positive integers:
		 * 
		 * n → n/2 (n is even) n → 3n + 1 (n is odd)
		 * 
		 * Using the rule above and starting with 13, we generate the following
		 * sequence:
		 * 
		 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
		 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
		 * been proved yet (Collatz Problem), it is thought that all starting numbers
		 * finish at 1.
		 * 
		 * Which starting number, under one million, produces the longest chain?
		 * 
		 * NOTE: Once the chain starts the terms are allowed to go above one million.
		 * 
		 * ANSWER = 837799
		 * 
		 * Complexity results
		 * BruteForce 4477 ms 
		 * Recursion 5961 ms 
		 * MapRecursion 10655 ms
		 */
		long startTime;

		startTime = System.currentTimeMillis();
		System.out.println(findChainRecursion(10000000));
		System.out.println((System.currentTimeMillis() - startTime) + " ms");

		startTime = System.currentTimeMillis();
		System.out.println(findChainWithMap(10000000));
		System.out.println((System.currentTimeMillis() - startTime) + " ms");

		startTime = System.currentTimeMillis();
		System.out.println(findChainBruteForce(10000000));
		System.out.println((System.currentTimeMillis() - startTime) + " ms");

	}

	static Map<Long, Long> map = new HashMap<Long, Long>();

	public static long findChainWithMap(long range) {

		long maxCount = 0;
		long maxStartNumber = 0;

		for (long i = 1; i < range; i++) {

			long counter = chainCounterWithMap(i, 1);
			if (counter > maxCount) {
				maxCount = counter;
				maxStartNumber = i;
			}

		}
		return maxStartNumber;
	}

	public static long chainCounterWithMap(long number, long counter) {
		if (map.containsKey(number))
			return map.get(number);
		if (number <= 1)
			return counter;
		counter = number % 2 == 0 ? chainCounterWithMap(number / 2, counter + 1)
				: chainCounterWithMap((3 * number + 1) / 2, counter + 2);
		if (map.containsKey(number))
			map.put(number, counter);
		return counter;
	}

	public static long findChainRecursion(long range) {

		long maxCount = 0;
		long maxStartNumber = 0;

		for (int i = 1; i < range; i++) {

			long counter = chainCounterRecursion(i, 1);
			if (counter > maxCount) {
				maxCount = counter;
				maxStartNumber = i;
			}

		}
		return maxStartNumber;
	}

	public static long chainCounterRecursion(long number, long counter) {
		if (number <= 1)
			return counter;
		else
			return number % 2 == 0 ? chainCounterRecursion(number / 2, counter + 1)
					: chainCounterRecursion((3 * number + 1) / 2, counter + 2);
	}

	public static int findChainBruteForce(int range) {
		int maxCount = 0;
		int maxStartNumber = 0;

		for (int i = 1; i < range; i++) {

			long currentNumber = i;
			int counter = 1;

			while (currentNumber > 1) {
				currentNumber = currentNumber % 2 == 0 ? currentNumber / 2 : 3 * currentNumber + 1;
				counter++;
			}
			// System.out.println("for "+i+" counter "+counter);

			if (counter > maxCount) {
				maxCount = counter;
				maxStartNumber = i;
			}
		}
		return maxStartNumber;
	}

}
