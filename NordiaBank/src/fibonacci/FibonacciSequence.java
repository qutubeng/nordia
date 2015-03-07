package fibonacci;

/*
 * Qutub Uddin Ahmed
 * Problem: 
 * 1. Add up all the even elements of the fibonacci sequence below 1000
 */

import java.math.BigInteger;

public class FibonacciSequence {
	
	private static BigInteger fibonacciMatrix(int n) {
		BigInteger[] matrix = { BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO };
		return matrixPow(matrix, n)[1];
	}
	
	// Computes the power of a matrix. The matrix is packed in row-major order.
	private static BigInteger[] matrixPow(BigInteger[] matrix, int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		BigInteger[] result = { BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE };
		
		// Exponentiation by squaring
		while (n != 0) {
			if (n % 2 != 0) {
				result = matrixMultiply(result, matrix);
			}
			n /= 2;
			matrix = matrixMultiply(matrix, matrix);
		}
		return result;
	}
		
	private static BigInteger[] matrixMultiply(BigInteger[] x, BigInteger[] y) {
		return new BigInteger[] {
			multiply(x[0], y[0]).add(multiply(x[1], y[2])),
			multiply(x[0], y[1]).add(multiply(x[1], y[3])),
			multiply(x[2], y[0]).add(multiply(x[3], y[2])),
			multiply(x[2], y[1]).add(multiply(x[3], y[3]))
		};
	}
		
	// Multiplies two BigIntegers. This function makes it easy to swap in a faster algorithm like Karatsuba multiplication.
	private static BigInteger multiply(BigInteger x, BigInteger y) {
		return x.multiply(y);
	}
	
	private static BigInteger getEvenElementsFibonacciSequence(int fiboNumber) {

		BigInteger result = BigInteger.valueOf(0);

		try {
			BigInteger[] fiboArray = new BigInteger[fiboNumber+1];

			for(int i=0; i <= fiboNumber; i++) {
				fiboArray[i] = fibonacciMatrix(i);
				
				//Considering the even numbers
				if(fiboArray[i].byteValue() % 2 == 0) {
					result = result.add(fiboArray[i]);
				}
			}
			
		} catch(NegativeArraySizeException nas) {
			//nas.printStackTrace();
			System.out.println("Please input + ve number");
			return null;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getEvenElementsFibonacciSequence(1000));
	}
}
