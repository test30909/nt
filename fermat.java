import java.util.Scanner;

public class FermatsLittleTheorem {
	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i * i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	private static boolean verifyTheorem(int a, int p) {
		if (!isPrime(p)) {
			System.out.println("ERROR | Number is not prime.");
			return false;
		}

		int result = 1;

		for (int i = 0; i < p - 1; i++) {
			result = (result * a) % p;
		}

		return result == 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter `a`: ");
		int a = scanner.nextInt();
		System.out.print("Enter `p`: ");
		int p = scanner.nextInt();

		if (verifyTheorem(a, p)) {
			System.out.println("INFO | Values satisfy the theorem.");
		} else {
			System.out.println("INFO | Values don't satisfy theorem.");
		}

		scanner.close();
	}
}
