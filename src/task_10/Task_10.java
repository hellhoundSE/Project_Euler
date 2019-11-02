package task_10;

import java.util.Arrays;

public class Task_10 {

	public static void main(String[] args) {
		/*
		 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
		 * 
		 * Find the sum of all the primes below two million.
		 * 
		 * BrutForce O(n^2)
		 * 
		 * Eratosthenes O(n * log(log(n))
		 */

		int limit = 2000000;
		

		System.out.println("BruteForse :");
	    long startTime = System.currentTimeMillis();
		System.out.println(bruteForse(limit)+" "+(System.currentTimeMillis() - startTime)+" ms");

	    System.out.println("Sieve of Eratosthenes :");
		startTime = System.currentTimeMillis();
		System.out.println(sieveOfEratosthenes(limit)+" "+(System.currentTimeMillis() - startTime)+" ms");

	

	}

	// extremely slow
	private static long bruteForse(int limit) {
		long sum = 2;
		for (int i = 3; i < limit; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// use a lot of memory but much more faster
	private static long sieveOfEratosthenes(int limit) {
		boolean[] isPrime = new boolean[limit];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		long sum = 0;
		for (long i = 2; i < limit; i++)
			if (isPrime[(int) i]) {
				sum += i;
				for (long j = i * i; j < limit; j += i)
					isPrime[(int) j] = false;
			}
		return sum;
	}
}
