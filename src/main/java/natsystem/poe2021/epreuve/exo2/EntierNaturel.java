package natsystem.poe2021.epreuve.exo2;


public class EntierNaturel {

	private Integer valeur = null;

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		if (valeur != null && valeur < 0) {
			System.err.println("Un entier naturel ne peut pas être négatif");
		}
		else {
			this.valeur = valeur;
		}
	}

	public EntierNaturel(Integer valeur) {
		super();
		setValeur(valeur);
	}



	public EntierNaturel() {
		super();
	}

	@Override
	public String toString() {
		return valeur + "";
	}

	public static EntierNaturel valueOf(Integer valeur) {
		boolean erreur = false;

		if(valeur < 0 && valeur != null) {
			erreur = true;
		}
		else {
			return new EntierNaturel(valeur);
		}
		return erreur ? null : new EntierNaturel(valeur);
	}

	public EntierNaturel incremente() {
		if (valeur != null) {
			this.setValeur(++valeur);
		}
		return this;	
	}

	public EntierNaturel add(EntierNaturel e) {
		setValeur(this.valeur + e.getValeur());
		return this;
	}

	public EntierNaturel add(Integer e) {
		if(e != null) {
			setValeur(this.valeur + e);
		}
		return this;
	}
	
	public static EntierNaturel add(EntierNaturel a, Long b) {
		return a.add(b.intValue());

	}
	
	public static EntierNaturel add(EntierNaturel a, EntierNaturel b) {
		return a.add(b);
	}
	
	public static EntierNaturel max(EntierNaturel a, EntierNaturel b) {
		return a.getValeur() > b.getValeur() ? a : b;
	}
	
	

	public boolean isZero() {
		return valeur.equals(0) ? true : false;
	}

	public EntierNaturel mod(EntierNaturel a, EntierNaturel b) {
		int modulo = a.getValeur() % b.getValeur();
		return new EntierNaturel(modulo);
	}

	public EntierNaturel quotient(EntierNaturel a, EntierNaturel b) {
		return b.getValeur() == 0 ? null : new EntierNaturel(a.getValeur() / b.getValeur());
	}

	public EntierNaturel pgcd(EntierNaturel a, EntierNaturel b) {

		EntierNaturel temp = new EntierNaturel(1);
		EntierNaturel reste = new EntierNaturel(1);

		if (b.getValeur() > a.getValeur()) {
			temp = a;
			a = b;
			b = temp;
		}

		do {
			reste = mod(a,b);
			a = b;
			b = reste;
		} while(b.getValeur() !=0);

		return a; 

	}

	public EntierNaturel pgcd(Long a, Long b) {

		long temp =  1;
		long reste = 1;

		if (b == 0) {
			return new EntierNaturel(a.intValue()); 
		} else if (a ==0) {
			return new EntierNaturel(b.intValue()); 
		} 

		if (b > a) {
			temp = a;
			a = b;
			b = temp;
		}

		do {
			reste = a % b;
			a = b;
			b = reste;
		} while(b !=0);

		return new EntierNaturel(a.intValue()); 

	}

	public boolean premiersEntreEux(EntierNaturel a, EntierNaturel b) {
		EntierNaturel resultat = pgcd(a,b);

		if (resultat.getValeur() == 1) {
			return true;
		} else {
			return false;
		}

	}




}



