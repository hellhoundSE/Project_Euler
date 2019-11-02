package task_5;


import java.util.HashMap;
import java.util.Map;

public class Task_5 {

	public static void main(String[] args) {

		/*
		 * 2520 is the smallest number that can be divided
		 *  by each of the numbers from 1 to 10 without any remainder.

			What is the smallest positive number that is evenly divisible by all 
			of the numbers from 1 to 20?
		 */
		

		System.out.println(findNumber(20));

		System.out.println(findNumberV2(20));

	}

	private static long findNumberV2(int num) {
		
		//mych more fastest way, but a bit hard to understand
		
		Map<Integer, Integer> primeNumbers = findPrimeNumbers(num);
		long answer = 1;
		
		for (int key : primeNumbers.keySet()) {
			int pow = (int) (Math.log(num) / Math.log(key));
			answer *= Math.pow(key, pow);
		}

		return answer;
	}

	private static long findNumber(int num) {

		long answer = 1;
		Map<Integer, Integer> primeNumbers = findPrimeNumbers(num);

		for (int i = 2; i <= num; i++) {

			
			// map which has prime numbers i consist of 
			Map<Integer, Integer> tempMap = findPrimeNumbers(i);

			int j = 2;
			int temp = i;

			// counting how much prime numbers needed to represent i
			while (temp != 1) {
				if (temp % j == 0) {
					temp = temp / j;
					tempMap.put(j, (tempMap.get(j) + 1));
				} else
					j++;
			}

			
			for (int key : tempMap.keySet()) {
				if (primeNumbers.get(key) < tempMap.get(key)) {
					primeNumbers.put(key, tempMap.get(key));
				}
			}

		}
		
		//finding final number by multiplying all used prime in power maximum time they were used
		for (int key : primeNumbers.keySet()) {
			answer *= Math.pow(key, primeNumbers.get(key));
		}

		return answer;
	}

	// returns map with all prime numbers less then NUM
	private static Map<Integer, Integer> findPrimeNumbers(int num) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 2; i <= num; i++) {
			if (isPrime(i)) {
				map.put(i, 0);
			}
		}

		return map;
	}

	
	//check if number is prime
	private static boolean isPrime(int num) {
		if (num == 1 || num == 2)
			return true;

		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
