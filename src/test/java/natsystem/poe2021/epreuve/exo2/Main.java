package natsystem.poe2021.epreuve.exo2;

public class Main {

	private static final int MAX = 4;

	public static void main(String[] args) {


		EntierNaturel a = new EntierNaturel(360);
		EntierNaturel b = new EntierNaturel(252);


		System.out.println(new EntierNaturel().pgcd(a, b));

		//System.out.println(EntierNaturel.add(a, 45L));

		System.out.println(EntierNaturel.max(a, b));

		System.out.println("+ | 0 | 1 | 2 | 3 | 4");

		System.out.println("----------------------");

		for (int i = 0; i <= MAX; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j <= MAX; j++) {
				System.out.print(EntierNaturel.add(new EntierNaturel(i), new EntierNaturel(j)));
				System.out.print(" | ");
			}
			System.out.println();
		}


	}

}
