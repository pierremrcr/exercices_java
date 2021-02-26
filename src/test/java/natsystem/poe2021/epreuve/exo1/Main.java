package natsystem.poe2021.epreuve.exo1;

public class Main {
	
    private static final double PROBA = 6 / Math.PI;
    private static final long MAX = 10000;

	public static void main(String[] args) {
		
		/*
		 * EntierNaturel en = new EntierNaturel(0);
		 * 
		 * boolean bool = en.isZero(); System.out.println(bool);
		 * 
		 * EntierNaturel e = new EntierNaturel();
		 * 
		 * System.out.println(e.mod(new EntierNaturel(123), new EntierNaturel(45)));
		 * 
		 * System.out.println(e.quotient(new EntierNaturel(15), new EntierNaturel(0)));
		 * 
		 * System.out.println(e.pgcd(new EntierNaturel(60), new EntierNaturel(8)));
		 * 
		 * System.out.println(e.pgcd(25L,15L));
		 * 
		 * System.out.println(e.pgcd(0L, 15L));
		 * 
		 * 
		 * System.out.println(e.premiersEntreEux(new EntierNaturel(5), new
		 * EntierNaturel(12)));
		 */
		
		System.out.println("Valeur proba : " + PROBA);
		
		EntierNaturel a = new EntierNaturel(360);
		EntierNaturel b = new EntierNaturel(252);
		
		
		System.out.println(new EntierNaturel().pgcd(a, b));
		
		EntierNaturel c = new EntierNaturel(0);
		
		
	}

}
