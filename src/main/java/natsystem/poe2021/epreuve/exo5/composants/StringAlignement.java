package natsystem.poe2021.epreuve.exo5.composants;

public class StringAlignement {
	
	private Justification justification;
	private String separateur;
	private int lgMaxSansSeparateur;
	private int lgMaxAvecSeparateur;
	
	
	public StringAlignement(Justification justification, int lgMaxSansSeparateur) {
		super();
		this.justification = justification;
		this.lgMaxSansSeparateur = lgMaxSansSeparateur;
	}
	
	
	public StringAlignement(Justification justification, String separateur, int lgMaxSansSeparateur) {
		super();
		this.justification = justification;
		this.separateur = separateur;
		this.lgMaxSansSeparateur = lgMaxSansSeparateur;
	}


	public Justification getJustification() {
		return justification;
	}
	public void setJustification(Justification justification) {
		this.justification = justification;
	}
	public String getSeparateur() {
		return separateur;
	}
	public void setSeparateur(String separateur) {
		this.separateur = separateur;
	}
	public int getLgMaxSansSeparateur() {
		return lgMaxSansSeparateur;
	}
	public void setLgMaxSansSeparateur(int lgMaxSansSeparateur) {
		this.lgMaxSansSeparateur = lgMaxSansSeparateur;
	}
	public int getLgMaxAvecSeparateur() {
		return lgMaxAvecSeparateur;
	}
	public void setLgMaxAvecSeparateur(int lgMaxAvecSeparateur) {
		this.lgMaxAvecSeparateur = lgMaxAvecSeparateur;
	}
	
	public String format (String chaine) {
		return null;
	}
	
	

}
