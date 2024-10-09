import java.util.Scanner;

class GCDExtended {
	public static void findGCD(long a, long b) {
		long x = 0, y = 1;
		long lastx = 1, lasty = 0;
		long temp;

		while (b != 0) {
			long quotient = a / b;
			long remainder = a % b;

			a = b;
			b = remainder;

			temp = x;
			x = lastx - quotient * x;
			lastx = temp;

			temp = y;
			y = lasty - quotient * y;
			lasty = temp;
		}

		System.out.println("GCD is " + a);
		System.out.println("Coefficients are " + lastx + " and " + lasty);
	}

	public static void main(String[] args) {
		long a = 64, b = 12;

		findGCD(a, b);
	}
}
