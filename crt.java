public class ChineseRemainderTheorem {
	private static int modInverse(int a, int m) {
		int m0 = m;
		int x0 = 0;
		int x1 = 1;
		if (m == 1) return 0;

		while (a > 1) {
			int q = a / m;
			int t = m;
			m = a % m;
			a = t;
			t = x0;
			x0 = x1 - q * x0;
			x1 = t;
		}

		if (x1 < 0) x1 += m0;

		return x1;
	}

	public static int chineseRemainder(int[] remainders, int[] moduli) {
		int prod = 1;
		for (int mod : moduli) {
				prod *= mod;
		}

		int result = 0;
		for (int i = 0; i < moduli.length; i++) {
			int ai = remainders[i];
			int ni = moduli[i];
			int niInverse = modInverse(prod / ni, ni);
			result += ai * niInverse * (prod / ni);
		}
		return result % prod;
	}

	public static void main(String[] args) {
		int[] remainders = {2, 3, 1};
		int[] moduli = {3, 5, 7};
		System.out.println(chineseRemainder(remainders, moduli));
	}
}
