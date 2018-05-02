package leetcode_java;

import java.util.ArrayList;

/*
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 */

public class Count_Primes_204 {

	// slow but can avoid 
	// Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
	public int countPrimes(int n) {
		if (n < 3) return 0;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			boolean isPrime = true;
			for(int index = 0; index < primes.size() && primes.get(index) < Math.sqrt(i); index++) {
				int prime = primes.get(index);
				if( (i % prime) == 0) {
					isPrime = false;
					break;
				}
				
			}
			// in case 3's square root is 1 which result in 3 is not a prime
			if( (i % (int) Math.sqrt(i) ) == 0 && ( (int) Math.sqrt(i) != 1) ) {
				isPrime = false;
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		return primes.size();
	}

	public int countPrimes2 (int n) {
		if (n < 3) return 0;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if ((i % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		return primes.size();
	}
	
	// may have exception thrown becasue of
	// Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
    public int countPrimesMeadiumFast(int n) {
    	int count = 0;
    	boolean[] nonprime = new boolean[n];
    	for(int i = 2; i < n; i++) {
    		if(!nonprime[i]) {
    			count++;
    			for(int j = 2; i*j < n; j++) {
    				nonprime[i*j] = true;
    			}
    		}
    	}
    	return count;
    }
    
    public int countPrimesFastest(int n) {
        if (n < 3) return 0;
        
        boolean[] nonprime = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (nonprime[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!nonprime[j]) {
                    --count;
                    nonprime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
    	Count_Primes_204 test = new Count_Primes_204();
    	System.out.println(test.countPrimesMeadiumFast(1));
    	System.out.println(test.countPrimesMeadiumFast(0));
    	System.out.println(test.countPrimesMeadiumFast(Integer.MAX_VALUE));
    }
}
