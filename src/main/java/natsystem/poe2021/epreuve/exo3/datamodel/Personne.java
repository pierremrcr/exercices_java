package natsystem.poe2021.epreuve.exo3.datamodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class Personne {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private int id;
	private String prenom;
	private String nom;
	private String ville;
	private Date dateDeNaissance;
	private Sexe sexe;
	private String metier;
	private Double longitude;
	private Double latitude;
	private int age;


	public Personne(int id, String prenom, String nom, String ville, String dateDeNaissance, Sexe sexe, String metier,
			Double longitude, Double latitude) throws ParseException {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.ville = ville;
		this.setDateDeNaissance(sdf.parse(dateDeNaissance)); 
		this.sexe = sexe;
		this.metier = metier;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	public Personne(int id, String prenom, String nom, String ville, Sexe sexe, String metier, Double longitude,
			Double latitude) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.ville = ville;
		this.sexe = sexe;
		this.metier = metier;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public Personne() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}



	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
		// Valorisation de l'âge
		if(dateDeNaissance != null) {
			Date today = new Date();
			long duree = today.toInstant().getEpochSecond() - this.dateDeNaissance.toInstant().getEpochSecond();
			this.age = (int)(duree / 86400 / 365.25);
		}
	}



	public Sexe getSexe() {
		return sexe;
	}



	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}



	public String getMetier() {
		return metier;
	}


	public void setMetier(String metier) {
		this.metier = metier;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return (sexe.equals(Sexe.HOMME) ? "M." : "Mme") +  ", prénom : " + prenom + ", nom : " + nom + ", âge : " + "(" + age + ")" +   
				", métier : " + metier + " à " + ville;
	}
	
	public static Comparator<Personne> ComparatorAge = new Comparator<Personne>() {

		@Override
		public int compare(Personne o1, Personne o2) {
			return (int) (o1.getAge() - o2.getAge() != 0 ? (int) (o1.getAge() - o2.getAge()) : o1.getNom().compareTo(o2.getNom()));
		}

	};



}
