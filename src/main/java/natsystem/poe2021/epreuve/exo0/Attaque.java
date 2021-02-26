package natsystem.poe2021.epreuve.exo0;


public class Attaque {


	private static final String CHAINE_VIDE = " ";
	private static final String MÊME_PAS_MAL = "Même pas mal";
	private static final String ÇA_SUFFIT_ARRÊTE = "ça suffit, arrête !";
	private static final String INCONNU = "?";
	private static final String AÏE = "aïe !";
	private static final String PAF = "paf !";

	public static String coup(String coup) {
		return PAF.equals(coup) ? AÏE : INCONNU;
	}

	public static String coup(int nombreAttaques, String coup) {
		
		int compteur = 0;


		for (int i = 0; i < nombreAttaques; i++) { 
			Attaque.coup(coup);
			compteur++;
			System.out.println("attaque " + compteur); 
		}


		if (compteur == 3 || compteur == 4) {
			return PAF.equals(coup) ? ÇA_SUFFIT_ARRÊTE : INCONNU;

		} else if (compteur >= 5) {
			return PAF.equals(coup) ? CHAINE_VIDE : MÊME_PAS_MAL;

		} else {
			return PAF.equals(coup) ? AÏE : INCONNU;
		}


	}



}


