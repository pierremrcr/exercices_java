package natsystem.poe2021.epreuve.exo3.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import natsystem.poe2021.epreuve.exo3.datamodel.Personne;
import natsystem.poe2021.epreuve.exo3.datamodel.Sexe;
import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;

public class DaoPersonne implements Dao<Personne> {

	private static DaoPersonne daoPersonne = null;

	private String repertoireRacine = "src/main/resources";
	private String repertoireRacinePersonne = repertoireRacine + "/personnes.txt";

	private DaoPersonne() {}

	// Singleton de la Dao Personne
	
	public static DaoPersonne getInstance() {
		if(daoPersonne == null) {
			daoPersonne = new DaoPersonne();
		}
		return daoPersonne;
	}


	public String getRepertoireRacine() {
		return repertoireRacine;
	}

	public void setRepertoireRacine(String repertoireRacine) {
		this.repertoireRacine = repertoireRacine;
	}

	public String getRepertoireRacinePersonne() {
		return repertoireRacinePersonne;
	}

	public void setRepertoireRacinePersonne(String repertoireRacinePersonne) {
		this.repertoireRacinePersonne = repertoireRacinePersonne;
	}

	
	@Override
	public List<Personne> loadAll() throws PersistenceException {
		
		List<Personne> listePersonnes = new ArrayList<>();
		String line = null;

		File repertoire = new File(this.repertoireRacinePersonne);
		if (!repertoire.exists()) throw new PersistenceException("Le répertoire de persistence pour les personnes n'existe pas");

		File fichier = new File(this.repertoireRacinePersonne);

		if (fichier.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader(fichier))) {
				
				//Lecture de la première ligne contenant le nom des champs (nom, prenom, ville...)
				br.readLine();

				//Tant que la ligne courante n'est pas null 
				while((line = br.readLine()) != null) {
					
					Personne p = null;

					// Suppression des espaces inutiles
					String lineWithoutSpaces = line.replaceAll("\\s+","");
					
					String[] champ = lineWithoutSpaces.split(",");

					String idStr = champ[0];
					String prenom = champ[1];
					String nom = champ[2];
					String ville = champ[3];
					String date_naissanceStr = champ[4];
					String sexStr = champ[5];
					String metier = champ[6];
					String longitudeStr = champ[7];
					String latitudeStr = champ[8];

					Double latitude = null;
					Double longitude = null;

					int id = 0;
					Sexe sexe = null;

					if(!"null".equalsIgnoreCase(idStr)) {
						id = Integer.parseInt(idStr);
					}

					if(!"null".equalsIgnoreCase(sexStr)) {
						if("H".equalsIgnoreCase(sexStr)) {
							sexe = Sexe.HOMME;
						} else {
							sexe = Sexe.FEMME;
						}
					}

					if (!"null".equalsIgnoreCase(latitudeStr)) {
						latitude = Double.parseDouble(latitudeStr);
					}
					
					if (!"null".equalsIgnoreCase(longitudeStr)) {
						longitude = Double.parseDouble(longitudeStr);
					}

					try {
						p = new Personne(id, prenom, nom, ville, date_naissanceStr, sexe, metier, longitude, latitude);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					listePersonnes.add(p);
				}

			} catch (IOException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

		return listePersonnes;
	}


}


