package fibonacci;

/*
 * Qutub Uddin Ahmed
 * Problem: 
 * 3. Write a recursive function that calculates the fibonacci sequence up to 1000
 */

import java.math.BigInteger;
import java.util.HashMap;

public class FibonacciSequenceRecursive {

	 private static HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
	    private static BigInteger ONE  = BigInteger.ONE;
	    private static BigInteger ZERO = BigInteger.ZERO;

	    public static BigInteger fibonacciRecursive(BigInteger n) {

	    	if(n.byteValue() > -1) {

	    		if (n.equals(ZERO)) return ZERO;
	    		if (n.equals(ONE))  return ONE;
	    		if (cache.containsKey(n)) return cache.get(n);

	    		//odd
	    		if(n.testBit(0)) {
	    			BigInteger n2 = n.shiftRight(1);
	    			BigInteger n3 = n2.add(ONE);
	    			BigInteger result = fibonacciRecursive(n2).multiply(fibonacciRecursive(n2)).add(fibonacciRecursive(n3).multiply(fibonacciRecursive(n3)));
	    			cache.put(n, result);
	    			
	    			return result;
	    		}

	    		// even
	    		else {
	    			BigInteger n2 = n.shiftRight(1);
	    			BigInteger n3 = n2.subtract(ONE);
	    			BigInteger result = fibonacciRecursive(n2).multiply(fibonacciRecursive(n2).add(fibonacciRecursive(n3).add(fibonacciRecursive(n3))));
	    			cache.put(n, result);
	    			return result;
	    		}
	    	}
	    	else {
	    		System.out.println("Please input + ve number");
	    		return null;
	    	}
	    }
	    
	    public static void main(String[] args) { 
	        BigInteger N = BigInteger.valueOf(100);
	        System.out.println(fibonacciRecursive(N));
	    }
}
