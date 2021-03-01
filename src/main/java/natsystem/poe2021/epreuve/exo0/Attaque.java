package natsystem.poe2021.epreuve.exo0;


public class Attaque {


	private static final String CHAINE_VIDE = " ";
	private static final String MEME_PAS_MAL = "Même pas mal";
	private static final String CA_SUFFIT_ARRETE = "ça suffit, arrête !";
	private static final String INCONNU = "?";
	private static final String AIE = "aïe !";
	private static final String PAF = "paf !";

	public static String coup(String coup) {
		return PAF.equals(coup) ? AIE : INCONNU;
	}

	public static String coup(int nombreAttaques, String coup) {
		
		int compteur = 0;


		for (int i = 0; i < nombreAttaques; i++) { 
			Attaque.coup(coup);
			compteur++;
			System.out.println("attaque " + compteur); 
		}


		if (compteur == 3 || compteur == 4) {
			return PAF.equals(coup) ? CA_SUFFIT_ARRETE : INCONNU;

		} else if (compteur >= 5) {
			return PAF.equals(coup) ? CHAINE_VIDE : MEME_PAS_MAL;

		} else {
			return PAF.equals(coup) ? AIE : INCONNU;
		}


	}



}


