import java.util.*;

public class PrimeFactorization {
	private static void primeFactors(int number) {
		if (number <= 1) {
			System.out.println("Number should be greater than 1.");
			return;
		}

		while (number % 2 == 0) {
			System.out.print(2 + " ");
			number /= 2;
		}

		for (int i = 3; i * i <= number; i++) {
			while (number % i == 0) {
				System.out.print(i + " ");
				number /= i;
			}
		}

		if (number > 2) {
			System.out.print(number);
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number: ");
		int number = scanner.nextInt();
		System.out.println("Prime factors of " + number + " are:");

		primeFactors(number);

		scanner.close();
	}
}
