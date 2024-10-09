import java.util.*;

public class MultiplicativeInverse {
	private static int[] extendedGCD(int a, int b) {
        	if (a == 0) {
            		return new int[]{b, 0, 1};
        	}

        	int[] result = extendedGCD(b % a, a);
        	int g = result[0];
        	int x1 = result[1];
        	int y1 = result[2];
        	int x = y1 - (b / a) * x1;
        	int y = x1;

		return new int[]{g, x, y};
	}

	private static int findModularInverse(int a, int n) {
		int[] result = extendedGCD(a, n);
		int gcd = result[0];
		int x = result[1];

		if (gcd != 1)
			return -1;
		else
			return (x % n + n) % n;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number (a): ");
		int a = scanner.nextInt();
		System.out.print("Enter the modulus (n): ");
		int n = scanner.nextInt();

		int inverse = findModularInverse(a, n);

		if (inverse == -1)
			System.out.println("No solution exists.");
		else
			System.out.println("The solution for " + a + " modulo " + n + " is: " + inverse);

		scanner.close();
	}
}
