package task_3;

public class Task_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * The prime factors of 13195 are 5, 7, 13 and 29.

			What is the largest prime factor of the number 600851475143 ?
		 * 
		 * O(sqrt(n))
		 */
		long number = 600851475143l;
		System.out.println(findLargestPrimeFactor(number));
		
	}
	
	public static long findLargestPrimeFactor(long num) {
		
		   int maxFactor = 2;
		   
		    while(maxFactor < Math.sqrt(num)) {
		    	
		        if(num % maxFactor == 0){
		            num = num / maxFactor;
		            maxFactor--;
		        }
		        maxFactor++;
		    }
		    
		    return num;
	}

}
