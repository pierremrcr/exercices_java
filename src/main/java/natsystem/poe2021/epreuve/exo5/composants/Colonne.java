package natsystem.poe2021.epreuve.exo5.composants;

public class Colonne {
	
	private String titre;
	private Justification justification;
	private int largeur;
	private StringAlignement stringAlignement;
	

	public Colonne(Justification justification, int largeur) {
		super();
		this.justification = justification;
		this.largeur = largeur;
	}
	
	
	
	public Colonne(String titre, Justification justification) {
		super();
		this.titre = titre;
		this.justification = justification;
	}



	public Colonne(String titre, Justification justification, int largeur) {
		super();
		this.titre = titre;
		this.justification = justification;
		this.largeur = largeur;
	}

	
	public StringAlignement getStringAlignement() {
		return stringAlignement;
	}


	public void setStringAlignement(StringAlignement stringAlignement) {
		this.stringAlignement = stringAlignement;
	}


	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Justification getJustification() {
		return justification;
	}
	
	public void setJustification(Justification justification) {
		this.justification = justification;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	

}
